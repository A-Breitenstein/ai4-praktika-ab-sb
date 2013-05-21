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
    private WindowBuffer windowBuffer;
    private FileCopyClient fileCopyClient;

    public Sender(String targetAddress, int port, int packet_maxsize,WindowBuffer windowBuffer,FileCopyClient fileCopyClient) {
        this.port = port;
        this.targetAddress = targetAddress;
        this.windowBuffer = windowBuffer;
        this.fileCopyClient = fileCopyClient;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    public DatagramSocket getSocket() {
        return socket;
    }
    public void run() {
        FCpacket tmp;
        while (!isInterrupted()) {
            tmp = windowBuffer.getNextPacket();
            if(tmp != null){
                tmp.setTimestamp(System.nanoTime());
                fileCopyClient.startTimer(tmp);
                send(tmp);

            }
            else{
                break;
            }
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
            interrupt();
        }
    }
}
