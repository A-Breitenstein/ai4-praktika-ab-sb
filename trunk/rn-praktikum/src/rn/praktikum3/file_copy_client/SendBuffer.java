package rn.praktikum3.file_copy_client;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
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
                tmp = sendMap.get(nextSeqNum++);
            }else{
                tmp = sendMap.get(timeOutQueue.poll());
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

            lock.release();
            freiePlaetze.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void markAsAcked(long seqNum) {
        FCpacket tmp = null;
        try {
            lock.acquire();
            tmp = sendMap.get(seqNum);
            if(tmp != null){
                tmp.setValidACK(true);
                fileCopyClient.cancelTimer(sendMap.get(seqNum));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.release();

        if (seqNum == sendbase) {
            while(tmp!=null && tmp.isValidACK() && sendbase <= nextSeqNum){
                try {
                    lock.acquire();
                    fileCopyClient.cancelTimer(sendMap.get(sendbase));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.release();
                removePacket(sendbase);
                sendbase+=1;
                tmp = sendMap.get(sendbase);
            }

        }
    }

    public void addSeqNumToTimeOutQueue(long seqNum) {
        try {
            lock.acquire();
            if(!sendMap.get(seqNum).isValidACK()){
                System.out.println("packet "+seqNum+" added to Timeout queue");
                timeOutQueue.add(seqNum);
                anzahlZuSendenePakete.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.release();
    }

//    public static final SendBuffer sb = new SendBuffer(10,new FileCopyClient("","","","10","10"));
//    public static void main(String[] args) {
//
//        final Queue<FCpacket> receivedpackeds = new ArrayDeque<FCpacket>();
//        //erzeuger
//        new Thread(new Runnable() {
//            int packetCount = 101;
//            int count = 0;
//            @Override
//            public void run() {
//                byte[] data = new byte[100];
//                while(count < packetCount){
//                    sb.putPacket(new FCpacket(count, data, data.length));
//                    System.out.println("Erzeuger erzeugte packet: "+count);
//                    count++;
//                }
//            }
//        }).start();
//
//        //sender
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                FCpacket tmp = null;
//                 while(true){
//                     tmp = sb.getNextPacket();
//                     receivedpackeds.add(tmp);
////                     try {
////                         Thread.sleep(4);
////                     } catch (InterruptedException e) {
////                         e.printStackTrace();
////                     }
//                     System.out.println("Sender versendet packet:" + tmp.getSeqNum());
//                 }
//            }
//        }).start();
//
//        //ack
//        new Thread(new Runnable() {
//            int count = 0;
//            @Override
//            public void run() {
//                FCpacket tmp = null;
//                while (true) {
//                    try {
//                        Thread.sleep(25);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    if(!receivedpackeds.isEmpty()){
//                        tmp = receivedpackeds.poll();
//                        if(count % 10 != 0) {
//                            sb.markAsAcked(tmp.getSeqNum());
//                        }
//                        System.out.println("AckReceiver received ack for packet:"+tmp.getSeqNum()+"  total: "+count);
//                        count++;
//
//
//                    }
//                }
//            }
//        }).start();
//    }
}
