package rn.praktikum2.client;

import rn.praktikum2.server.ChatCommands;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Alex
 * Date: 19.04.13
 * Time: 03:42
 */
public class ServerConnection implements Runnable{

    ChatClient chatClient;

    public Map<String,String> userToIp;

    private String serverIp;
    private int serverPort;

    private Socket serverSocket;


    public ServerConnection(ChatClient chatClient, String serverIp, int serverPort) throws IOException {
        this.chatClient = chatClient;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.userToIp = new HashMap<String, String>();
        this.serverSocket = new Socket(serverIp, serverPort);

    }

    public Socket getServerSocket() {
        return serverSocket;
    }

    public ChatClient getChatClient() {
        return chatClient;
    }

    public String getServerIp() {
        return serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public boolean isSocketClosed() {
        return serverSocket.isClosed();
    }

    public Map<String, String> getUserToIp() {
        return userToIp;
    }

    @Override
    public void run() {

        String response;
        String[] responseParts;
        Map<String,String> userToIpTemp = new HashMap<String, String>();
        while (!serverSocket.isClosed() && !Thread.interrupted()) {
            chatClient.writeToServer(ChatCommands.INFO.name());

            response = chatClient.readFromServer();
            responseParts = response.split(" ");


            userToIpTemp.clear();
            for (int i = 2; i < responseParts.length; i++) {
                userToIpTemp.put(responseParts[i + 1], responseParts[i]);
                i++;
            }

            if (!userToIp.equals(userToIpTemp)) {
                synchronized (userToIp) {userToIp = new HashMap<String, String>(userToIpTemp);}
                chatClient.displayUsers(new ArrayList<String>(userToIp.keySet()));
            }


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
