package rn.praktikum3.file_copy_client;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * User: abg667
 * Date: 13.05.13
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class WindowBuffer {
    public static WindowBuffer instance;
    private final BlockingQueue<FCpacket> buffer;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private int windowSize;
    private long sendBase = FileCopyClient.sequenzStart;
    private long nextSeqNum = FileCopyClient.sequenzStart;
    private long sendBaseP1;
    private FileCopyClient fileCopyClient;
    private Map<String, FCpacket> windowMap;
    //    private ConcurrentHashMap<String,FCpacket> windowMap;
    private Queue<Long> timeOutQueue;
    private BlockingQueue<FCpacket> zuSendenePakete;
    private Semaphore freiePlaetze;
    private Semaphore belegtePlaetze;
    private Semaphore timeOutQueueLock;
    private Semaphore windowBufferLOck;


    public WindowBuffer(FileCopyClient fileCopyClient, int windowSize) {
        this.fileCopyClient = fileCopyClient;
        this.windowSize = windowSize;
        this.instance = this;

        windowMap = new HashMap<String, FCpacket>();
        timeOutQueue = new ArrayDeque<Long>();
        zuSendenePakete = new ArrayBlockingQueue<FCpacket>(windowSize, true);
        buffer = new LinkedBlockingQueue<FCpacket>(windowSize);
        freiePlaetze = new Semaphore(windowSize, true);
        belegtePlaetze = new Semaphore(0);


        timeOutQueueLock = new Semaphore(1, true);
        windowBufferLOck = new Semaphore(1, true);

    }

    public void putPacket(FCpacket fCpacket) {
        try {
            buffer.put(fCpacket);
            zuSendenePakete.put(fCpacket);
            if (FileCopyClient.TEST_OUTPUT_MODE) {
                fileCopyClient.testOut("Packet mit " + fCpacket.getSeqNum() + " zum buffer hinzugefügt");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public FCpacket getNextPacket() {
        FCpacket packet = null;
        try {
            packet = zuSendenePakete.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (FileCopyClient.TEST_OUTPUT_MODE && packet != null)
            fileCopyClient.testOut("Packet mit " + (packet.getSeqNum()) + " wurde abgeschickt");
        return packet;


    }

    public void ackPacketReceived(FCpacket ackPacket) {
        readLock.lock();
        try {
            FCpacket packet = findPacket(buffer, ackPacket.getSeqNum());
            if (packet != null) {
                fileCopyClient.cancelTimer(packet);
                fileCopyClient.computeTimeoutValue(ackPacket.getTimestamp() - packet.getTimestamp());
                packet.setValidACK(true);
                if (packet.getSeqNum() == sendBase) {
                    writeLock.lock();
                    try {
                        while (packet != null && packet.isValidACK()) {
                            removeAllPacketsWithSeqNum(zuSendenePakete, sendBase);
                            buffer.poll();
                            System.out.println("packet " + sendBase + " aus dem Buffer entfernt");
                            sendBase++;
                            packet = buffer.peek();
                            System.out.println("buffer size nach poll: " + buffer.size());
                        }

                    } finally {
                        writeLock.unlock();
                    }
                }

            }

        } finally {
            readLock.unlock();
        }
    }

    private FCpacket findPacket(BlockingQueue<FCpacket> queue, long seqNum) {
        for (FCpacket fCpacket : queue) {
            if (fCpacket.getSeqNum() == seqNum)
                return fCpacket;
        }
        return null;
    }

    private boolean removeAllPacketsWithSeqNum(BlockingQueue<FCpacket> queue, long seqNum) {
        final List<FCpacket> willBeRemoved = new ArrayList<FCpacket>();
        for (FCpacket fCpacket : queue) {
            if (fCpacket.getSeqNum() == seqNum)
                willBeRemoved.add(fCpacket);
        }
        return queue.removeAll(willBeRemoved);
    }

    public void timeOut(long seqNum) {
        try {
            FCpacket fCpacket = findPacket(buffer, seqNum),
                     fCSendPackage;
            readLock.lock();
            try {
                fCSendPackage = findPacket(zuSendenePakete, seqNum);
            } finally {
                readLock.unlock();
            }
                if (fCpacket != null && !fCpacket.isValidACK() && fCSendPackage != null) {
                    System.out.println("timeout triggert for " + seqNum);
                    System.out.println("size zuSendenePakete " + zuSendenePakete.size());
                    writeLock.lock();
                    try {
                        zuSendenePakete.put(fCpacket);
                    } finally {
                        writeLock.unlock();
                    }
                }


        } catch (InterruptedException iE) {
            iE.printStackTrace();
        }
    }
}
