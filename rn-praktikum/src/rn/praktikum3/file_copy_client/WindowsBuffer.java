package rn.praktikum3.file_copy_client;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * User: Alex
 * Date: 14.05.13
 * Time: 23:41
 */
public class WindowsBuffer {
    public static WindowsBuffer instance;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock rQueueLock = lock.readLock();
    private final Lock wQueueLock = lock.writeLock();
    private final Lock rMapLock = lock.readLock();
    private final Lock wMapLock = lock.writeLock();
    private int windowSize;
    private long sendBase = FileCopyClient.sequenzStart;
    private long nextSeqNum = FileCopyClient.sequenzStart;
    private FileCopyClient fileCopyClient;
    private Map<String, FCpacket> packageMap;
    private Queue<FCpacket> priorityPackages;
    private Semaphore neededPackages,
            availablePackages;

    public WindowsBuffer(FileCopyClient fileCopyClient, int windowSize) {
        this.fileCopyClient = fileCopyClient;
        this.windowSize = windowSize;
        this.instance = this;

        packageMap = new HashMap<String, FCpacket>();
        priorityPackages = new ArrayDeque<FCpacket>();

        neededPackages = new Semaphore(windowSize);
        availablePackages = new Semaphore(0);
    }

    public void putPacket(FCpacket fCpacket) {

        try {
            neededPackages.acquire();

            wMapLock.lock();
            try {
                packageMap.put(String.valueOf(fCpacket.getSeqNum()), fCpacket);
            } finally {
                wMapLock.unlock();
            }

            availablePackages.release();

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public FCpacket getNextPacket() {

        FCpacket fCpacket = null;

        try {
            availablePackages.acquire();


            rQueueLock.lock();
            try {

                if (!priorityPackages.isEmpty()) {
                    fCpacket = priorityPackages.poll();
                }

            } finally {
                rQueueLock.unlock();
            }

            if (fCpacket == null) {
                rMapLock.lock();
                try {
                    fCpacket = packageMap.get(String.valueOf(nextSeqNum));
                    nextSeqNum++;
                } finally {
                    rMapLock.unlock();
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return fCpacket;

    }

    public void ackPacketReceived(FCpacket ackPacket) {

        FCpacket fCpacket = null;

        rMapLock.lock();
        try {

            fCpacket = packageMap.get(String.valueOf(ackPacket.getSeqNum()));
        } finally {
            rMapLock.unlock();
        }

        if (fCpacket != null) {
            fileCopyClient.cancelTimer(fCpacket);
            fileCopyClient.computeTimeoutValue(ackPacket.getTimestamp() - fCpacket.getTimestamp());
            fCpacket.setValidACK(true);

            if (fCpacket.getSeqNum() == sendBase) {
                while (fCpacket != null && fCpacket.isValidACK()) {

                    wMapLock.lock();
                    try {

                        packageMap.remove(String.valueOf(sendBase));

                        sendBase++;

                    } finally {
                        wMapLock.unlock();
                    }

                }

            }
        }

    }

    public void timeOut(long seqNum) {


        FCpacket fCpacket = null;
        rMapLock.lock();
        try {
            if (packageMap.containsKey(String.valueOf(seqNum)))
                fCpacket = packageMap.get(String.valueOf(seqNum));
        } finally {
            rMapLock.unlock();
        }

        if (fCpacket != null && !fCpacket.isValidACK()) {
            wQueueLock.lock();
            try {
                priorityPackages.add(fCpacket);
            } finally {
                wQueueLock.unlock();
            }
        }

    }
}
