package rn.praktikum2.client;

import java.net.SocketException;

/**
 * User: Alex
 * Date: 19.04.13
 * Time: 20:22
 */
public class TestUDP {


    public static void main(String[] args) {
        try {
            ChatClient chatClient = new ChatClient();
            UdpListener listener = UdpListener.create(chatClient, 55555);

            Thread listenerThread = new Thread(listener);
            listenerThread.start();

            UdpSender sender = UdpSender.create(chatClient, 55555);


            sender.sendMessage("sesambrötchen !!!!! \nyeah!");
        } catch (SocketException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
