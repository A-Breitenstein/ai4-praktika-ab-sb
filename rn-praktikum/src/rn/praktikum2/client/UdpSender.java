package rn.praktikum2.client;

import java.io.IOException;
import java.net.*;
import java.util.List;

/**
 * User: Alex
 * Date: 19.04.13
 * Time: 03:43
 */
public class UdpSender{

    ChatClient chatClient;

    DatagramSocket socket;

    int port;

    final int MaxMessageSize = 1000;

    byte[] buffer = new byte[MaxMessageSize];

    DatagramPacket datagramPacket;

    private UdpSender(ChatClient chatClient, int port) throws SocketException {
        this.chatClient = chatClient;
        this.port = port;

        socket = new DatagramSocket();
    }

    public static UdpSender create(ChatClient chatClient, int port) throws SocketException {
        return new UdpSender(chatClient, port);
    }

    public void sendMessage(String message) {
        if (message.length() > MaxMessageSize) throw new IllegalArgumentException("message is too long");

        final String outGoingMessage = String.valueOf(chatClient.getUsername());

        outGoingMessage.concat(": ").concat(message);

        buffer = outGoingMessage.getBytes();


        List<String> addressList = chatClient.getIpList();

        for (String targetAddress : addressList) {
            try {
                datagramPacket = new DatagramPacket(buffer, buffer.length,InetAddress.getByName(targetAddress),port);
                socket.send(datagramPacket);
            } catch (UnknownHostException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }
}
