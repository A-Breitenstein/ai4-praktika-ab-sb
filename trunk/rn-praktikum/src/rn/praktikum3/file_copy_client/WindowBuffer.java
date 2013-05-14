package rn.praktikum3.file_copy_client;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: abg667
 * Date: 13.05.13
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class WindowBuffer {
    private int windowSize;
    private long sendBase = FileCopyClient.sequenzStart;
    private long nextSeqNum = FileCopyClient.sequenzStart;
    private long sendBaseP1;

    private FileCopyClient fileCopyClient;
//    private Map<Long, FCpacket> windowMap;
    private ConcurrentHashMap<String,FCpacket> windowMap;

    private Queue<Long> timeOutQueue;
    private Semaphore freiePlaetze;
    private Semaphore belegtePlaetze;
    private Semaphore zuSendenePakete;
    private Semaphore timeOutQueueLock;
    private Semaphore windowBufferLOck;
    private final Semaphore versendetePakte;

    public WindowBuffer(FileCopyClient fileCopyClient, int windowSize) {
        this.fileCopyClient = fileCopyClient;
        this.windowSize = windowSize;

        windowMap = new ConcurrentHashMap<String, FCpacket>();
        timeOutQueue = new ArrayDeque<Long>();

        freiePlaetze = new Semaphore(windowSize,true);
        belegtePlaetze = new Semaphore(0);

        zuSendenePakete = new Semaphore(0,true);
        versendetePakte = new Semaphore(0,true);


        timeOutQueueLock = new Semaphore(1,true);
        windowBufferLOck = new Semaphore(1,true);
        
    }

    public void putPacket(FCpacket fCpacket) {
        try {
            freiePlaetze.acquire();
                windowBufferLOck.acquire();
                if(FileCopyClient.TEST_OUTPUT_MODE)
                    fileCopyClient.testOut("Packet mit "+fCpacket.getSeqNum()+" zum buffer hinzugefügt");
                    windowMap.put(String.valueOf(fCpacket.getSeqNum()), fCpacket);
            if (zuSendenePakete.availablePermits() > windowSize)
                zuSendenePakete.acquire(zuSendenePakete.availablePermits() - windowSize-1);
            belegtePlaetze.release();
            windowBufferLOck.release();
            zuSendenePakete.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public FCpacket getNextPacket() {
        FCpacket packet = null;
        try {
            zuSendenePakete.acquire();

            windowBufferLOck.acquire();
                timeOutQueueLock.acquire();
            if (!timeOutQueue.isEmpty()) {
                long l = timeOutQueue.poll();
                packet = windowMap.get(String.valueOf(l));

                if (packet == null) {
                    System.out.println("whyyyyyyy");
                }
            }else{
                packet = windowMap.get(new Long(nextSeqNum).toString());
                if (packet == null) {
                    packet = windowMap.get(String.valueOf(nextSeqNum));
                    System.out.println("whyyyyyyy");
                }
                nextSeqNum++;
            }

            timeOutQueueLock.release();
            windowBufferLOck.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(FileCopyClient.TEST_OUTPUT_MODE)
            fileCopyClient.testOut("Packet mit "+(nextSeqNum-1)+" wurde abgeschickt");
        
        return packet;


    }
    public void ackPacketReceived(FCpacket ackPacket){
        try {
            windowBufferLOck.acquire();
            FCpacket packet = windowMap.get(String.valueOf(ackPacket.getSeqNum()));
            int removeCounter = 0;
            if (packet != null) {
                fileCopyClient.cancelTimer(packet);
                fileCopyClient.computeTimeoutValue(ackPacket.getTimestamp() - packet.getTimestamp());
                packet.setValidACK(true);

                if (packet.getSeqNum() == sendBase) {
                    removeCounter = 0;
                    timeOutQueueLock.acquire();
                    while (packet != null && packet.isValidACK()) {
                        belegtePlaetze.acquire();
                        timeOutQueue.remove(sendBase);
                        windowMap.remove(String.valueOf(sendBase));
                        removeCounter++;
                        sendBase++;
                        packet = windowMap.get(String.valueOf(sendBase));
                        if (packet == null) {
                            System.out.println("SendBase: " + sendBase + ", nextSeqNum: " + nextSeqNum);
                        }
                    }
                    timeOutQueueLock.release();
                }

            }

            windowBufferLOck.release();
            freiePlaetze.release(removeCounter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void timeOut(long seqNum) {
            try {
                windowBufferLOck.acquire();
                try {
                    timeOutQueueLock.acquire();
                    FCpacket fCpacket = windowMap.get(String.valueOf(seqNum));
                    if (fCpacket != null && !fCpacket.isValidACK() && !timeOutQueue.contains(seqNum)) {
                        timeOutQueue.add(new Long(seqNum));
                        System.out.println("timeout triggert for " + seqNum);
                        if (zuSendenePakete.availablePermits() > windowSize)
                            zuSendenePakete.acquire(zuSendenePakete.availablePermits() - windowSize-1);
                        zuSendenePakete.release();

                    }
                    timeOutQueueLock.release();
                } catch (InterruptedException iE) {
                    iE.printStackTrace();
                    timeOutQueueLock.release();
                }
                windowBufferLOck.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
                windowBufferLOck.release();
            }

    }
}
