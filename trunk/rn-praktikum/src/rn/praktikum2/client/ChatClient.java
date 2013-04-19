package rn.praktikum2.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abg667
 * Date: 18.04.13
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
public class ChatClient {
    ServerConnection serverConnection;
    UdpSender sender;
    UdpListener listener;
    private String username;

   /* public void connect() {
        byte[] content = String.valueOf("TestGUI String\r\n").getBytes();

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    byte[] response_body = new byte[100];

                    try {
                        udListener = new DatagramSocket();
                        DatagramPacket response = new DatagramPacket(response_body, response_body.length, InetAddress.getLocalHost(), 50001);
                        System.out.println("wait for response");
                        udListener.receive(response);
                        System.out.println(response.getData().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            udpSender = new DatagramSocket();
            Thread.sleep(1500);
            DatagramPacket packet = new DatagramPacket(content, content.length, InetAddress.getLocalHost(), 50001);
            for (int i = 0; i < 20; i++) {
                udpSender.send(packet);
            }
            System.out.println("send");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
//        new ChatClient().connect();
    }

    public boolean tcpSocketConnected() {
        return !serverConnection.isSocketClosed();
    }

    public String getUsername() {
        return username;
    }

    public List<String> getIpList() {
        return new ArrayList<String>(serverConnection.getUserToIp().values());
    }
}
