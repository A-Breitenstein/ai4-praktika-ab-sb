package rn.praktikum3.file_copy_client;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: Sven
 * Date: 12.05.13
 * Time: 16:15
 */
public class SendBuffer {
    private int size;
    private Semaphore freiePlaetze, belegtePlaetze, lock, anzahlZuSendenePakete;
    private Map<Long, FCpacket> sendMap;
    private long sendbase = FileCopyClient.sequenzStart;
    private long nextSeqNum = FileCopyClient.sequenzStart;
    private FileCopyClient fileCopyClient;
    private Queue<Long> timeOutQueue;

    public SendBuffer(int size, FileCopyClient fileCopyClient) {
        this.size = size;
        this.fileCopyClient = fileCopyClient;
        sendMap = new HashMap<Long, FCpacket>();
        freiePlaetze = new Semaphore(size);
        belegtePlaetze = new Semaphore(0);
        anzahlZuSendenePakete = new Semaphore(0);
        lock = new Semaphore(1,true);
        timeOutQueue = new ArrayDeque();


    }

    public void putPacket(FCpacket fcpacket) {
        try {
            freiePlaetze.acquire();
            lock.acquire();
                sendMap.put(fcpacket.getSeqNum(), fcpacket);
            lock.release();
            belegtePlaetze.release();
            anzahlZuSendenePakete.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public FCpacket getNextPacket() {
        FCpacket tmp = null;
        try {
            anzahlZuSendenePakete.acquire();
            lock.acquire();
            if(timeOutQueue.isEmpty()){
                tmp = sendMap.get(nextSeqNum);
                nextSeqNum+=1;
                tmp.setTimestamp(System.nanoTime());
            }else{
                tmp = sendMap.get(timeOutQueue.poll());
                tmp.setTimestamp(System.nanoTime());
            }
            fileCopyClient.startTimer(tmp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.release();
        return tmp;
    }

    public void removePacket(long seqNum) {
        try {
            belegtePlaetze.acquire();
            lock.acquire();

                sendMap.remove(seqNum);
                timeOutQueue.remove(seqNum);

            lock.release();
            freiePlaetze.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void markAsAcked(FCpacket ACKPacket) {
        FCpacket tmp = null;
        final long seqNum = ACKPacket.getSeqNum();

        tmp = sendMap.get(seqNum);
        if(tmp != null){
            tmp.setValidACK(true);
            fileCopyClient.cancelTimer(sendMap.get(seqNum));
            fileCopyClient.computeTimeoutValue(ACKPacket.getTimestamp()-tmp.getTimestamp());
        }


        if (seqNum == sendbase) {
            while(tmp!=null && tmp.isValidACK() && sendbase < nextSeqNum){
                fileCopyClient.cancelTimer(sendMap.get(sendbase));
                removePacket(sendbase);
                sendbase+=1;
                tmp = sendMap.get(sendbase);
            }

        }
    }

    public void addSeqNumToTimeOutQueue(long seqNum) {
        try {
            lock.acquire();
            FCpacket tmp = sendMap.get(seqNum);
            if(tmp != null && !tmp.isValidACK()){
                System.out.println("packet "+seqNum+" added to Timeout queue");
                timeOutQueue.add(seqNum);
                anzahlZuSendenePakete.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.release();
    }

}
