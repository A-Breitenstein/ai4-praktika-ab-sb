package rn.praktikum3.file_copy_client;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Semaphore;

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
    private Map<Long, FCpacket> windowMap;

    private Queue<Long> timeOutQueue;
    private Semaphore freiePlaetze;
    private Semaphore belegtePlaetze;
    private Semaphore zuSendenePakete;
    private Semaphore timeOutQueueLock;
    private Semaphore windowBufferLock;

    public WindowBuffer(FileCopyClient fileCopyClient, int windowSize) {
        this.fileCopyClient = fileCopyClient;
        this.windowSize = windowSize;

        windowMap = new HashMap<Long, FCpacket>();
        timeOutQueue = new ArrayDeque<Long>();

        freiePlaetze = new Semaphore(windowSize);
        belegtePlaetze = new Semaphore(0);
        zuSendenePakete = new Semaphore(0);
        timeOutQueueLock = new Semaphore(1,true);
        windowBufferLock = new Semaphore(1,true);

    }

    public void putPacket(FCpacket fCpacket) {
        try {
            freiePlaetze.acquire();
                windowBufferLock.acquire();
                    windowMap.put(fCpacket.getSeqNum(), fCpacket);
                    if (windowMap.size() > windowSize)
                        System.out.println("whyyyyy map whyyyy");
                zuSendenePakete.release();
                windowBufferLock.release();
//            belegtePlaetze.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public FCpacket getNextPacket() {
        FCpacket packet = null;
        try {
            zuSendenePakete.acquire();
                timeOutQueueLock.acquire();
                windowBufferLock.acquire();
            if(!timeOutQueue.isEmpty())
                packet = windowMap.get(timeOutQueue.poll());
             else
                packet = windowMap.get(nextSeqNum++);

            if (packet == null) {
                System.out.println("whyyyyyyy");
            }
                windowBufferLock.release();
                timeOutQueueLock.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return packet;


    }
    public void ackPacketReceived(FCpacket ackPacket){
        FCpacket packet = windowMap.get(ackPacket.getSeqNum());
        if (packet != null) {
            fileCopyClient.cancelTimer(packet);
            fileCopyClient.computeTimeoutValue(ackPacket.getTimestamp() - packet.getTimestamp());
            packet.setValidACK(true);
            if (ackPacket.getSeqNum() == sendBase) {
                int removes = 0;
                try {
                    windowBufferLock.acquire();
                    while (packet != null &&packet.isValidACK()) {

    //                        belegtePlaetze.acquire();
                            timeOutQueueLock.acquire();
                            timeOutQueue.remove(sendBase);
                            timeOutQueueLock.release();

                                int before = windowMap.size();
                                windowMap.remove(sendBase);
                                removes++;

                                if(before == windowMap.size())
                                    System.out.println("wooot");
                                packet = windowMap.get(++sendBase);




                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                windowBufferLock.release();
                freiePlaetze.release(removes);
            }
        }



    }
    public void timeOut(long seqNum) {
        try {
            timeOutQueueLock.acquire();
            if(!timeOutQueue.contains(seqNum)){
                timeOutQueue.add(seqNum);
                zuSendenePakete.release();
            }
            timeOutQueueLock.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
