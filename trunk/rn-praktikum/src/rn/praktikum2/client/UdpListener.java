package rn.praktikum2.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * User: Alex
 * Date: 19.04.13
 * Time: 03:43
 */
public class UdpListener implements Runnable {

    ChatClient chatClient;

    DatagramSocket socket;

    int port;

    byte[] buffer = new byte[121];

    DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

    private UdpListener(ChatClient chatClient, int port) {
        this.chatClient = chatClient;
        this.port = port;
    }

    public static UdpListener create(ChatClient chatClient, int port) {
        return new UdpListener(chatClient, port);
    }

    @Override
    public void run() {

        String message;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        while (!Thread.interrupted()) {  //!Thread.interrupted() || !chatClient.tcpSocketConnected()
            try {
                socket.receive(datagramPacket);
                message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

                chatClient.displayMessage(message.trim());
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
