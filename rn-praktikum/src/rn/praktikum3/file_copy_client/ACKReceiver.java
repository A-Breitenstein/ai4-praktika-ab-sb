package rn.praktikum3.file_copy_client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * User: Sven
 * Date: 12.05.13
 * Time: 15:26
 */
public class ACKReceiver extends Thread {
    private DatagramSocket udpReceiver;
    private DatagramPacket datagramPacket;
    private byte[] dataBuffer;
    private int port;
    private ACKListener callbackListner;
    public ACKReceiver(int port, int udp_packet_size,ACKListener listener) {
        dataBuffer = new byte[8];
        this.port = port;
        callbackListner = listener;
        datagramPacket = new DatagramPacket(dataBuffer,dataBuffer.length);
    }

    public void run() {
        try {
            udpReceiver = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        while (!Thread.interrupted()) {
            try {
                udpReceiver.receive(datagramPacket);
                FCpacket paket = new FCpacket(datagramPacket.getData(),datagramPacket.getLength());

                callbackListner.receivedACK(paket.getSeqNum());

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public interface ACKListener{
        void receivedACK(long seqNum);
    }

}
