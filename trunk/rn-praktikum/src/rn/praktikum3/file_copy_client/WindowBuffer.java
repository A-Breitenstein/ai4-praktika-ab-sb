package rn.praktikum3.file_copy_client;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: abg667
 * Date: 13.05.13
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class WindowBuffer {
    public static WindowBuffer instance;
    private int windowSize;
    private long sendBase = FileCopyClient.sequenzStart;
    private FileCopyClient fileCopyClient;

    private final BlockingQueue<FCpacket> buffer;
    private final BlockingQueue<FCpacket> zuSendenePakete;
    private boolean fileEndReached = false;


    public WindowBuffer(FileCopyClient fileCopyClient, int windowSize) {
        this.fileCopyClient = fileCopyClient;
        this.windowSize = windowSize;
        this.instance = this;
        zuSendenePakete = new ArrayBlockingQueue<FCpacket>(windowSize*2,true);
        buffer = new LinkedBlockingQueue<FCpacket>(windowSize);
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
            return null;
        }

        if(FileCopyClient.TEST_OUTPUT_MODE && packet != null)
            fileCopyClient.testOut("Packet mit "+(packet.getSeqNum())+" wurde abgeschickt");
        return packet;
    }
    public void ackPacketReceived(FCpacket ackPacket){
            synchronized (buffer){
                FCpacket packet = findPacket(buffer,ackPacket.getSeqNum());
                if (packet != null) {
                    fileCopyClient.cancelTimer(packet);
                    fileCopyClient.computeTimeoutValue(ackPacket.getTimestamp() - packet.getTimestamp());
                    packet.setValidACK(true);
                    if (packet.getSeqNum() == sendBase) {
                        synchronized (zuSendenePakete){
                            while (packet != null && packet.isValidACK()) {
                                removeAllPacketsWithSeqNum(zuSendenePakete,sendBase);
                                buffer.poll();
//                                System.out.println("packet " + sendBase + " aus dem Buffer entfernt");
                                sendBase++;
                                packet = buffer.peek();
//                                System.out.println("buffer size nach poll: "+buffer.size());
                            }

                        }
                    }

                }

            }
    }
    private FCpacket findPacket(BlockingQueue<FCpacket> queue,long seqNum) {
        for (FCpacket fCpacket : queue) {
            if(fCpacket.getSeqNum() == seqNum)
                return fCpacket;
        }
        return null;
    }
    private boolean removeAllPacketsWithSeqNum(BlockingQueue<FCpacket> queue, long seqNum) {
        final List<FCpacket> willBeRemoved = new ArrayList<FCpacket>();
        for (FCpacket fCpacket : queue) {
            if(fCpacket.getSeqNum() == seqNum)
                willBeRemoved.add(fCpacket);
        }
        return queue.removeAll(willBeRemoved);
    }

    public void timeOut(long seqNum) {
        synchronized (buffer) {
            try {
                FCpacket fCpacket = findPacket(buffer, seqNum);
                synchronized (zuSendenePakete) {
                    if (fCpacket != null && !fCpacket.isValidACK() && findPacket(zuSendenePakete, seqNum) == null) {
                        FileCopyClient.lostPackets++;
                        zuSendenePakete.put(fCpacket);
                    }
                }
            } catch (InterruptedException iE) {
                iE.printStackTrace();
            }
        }
    }

    public void fileEndReached(long seqNum) {
        fileEndReached = true;
    }

    public boolean isEmpty() {
        return fileEndReached && buffer.isEmpty();
    }
}
