package rn.praktikum3.file_copy_client;

import java.io.IOException;
import java.net.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sven
 * Date: 12.05.13
 * Time: 21:50
 */
public class Sender extends Thread {
    private DatagramSocket socket;
    private DatagramPacket datagramPacket;
    private int port;
    private String targetAddress;
    private byte[] buffer;
    private SendBuffer sendBuffer;

    public Sender(String targetAddress, int port, int packet_maxsize,SendBuffer sendBuffer) {
        this.port = port;
        this.targetAddress = targetAddress;
        this.sendBuffer = sendBuffer;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        FCpacket tmp;
        while (!isInterrupted()) {
            tmp = sendBuffer.getNextPacket();
            if(tmp != null)
                send(tmp);
            else
                break;
        }

    }

    public void send(FCpacket fCpacket){
        buffer = fCpacket.getSeqNumBytesAndData();
        try {
            datagramPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(targetAddress), port);
            socket.send(datagramPacket);
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
