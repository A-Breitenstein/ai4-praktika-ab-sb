package rn.praktikum2.client;

import java.net.Socket;
import java.util.Map;

/**
 * User: Alex
 * Date: 19.04.13
 * Time: 03:42
 */
public class ServerConnection {

    ChatClient chatClient;

    public Map<String,String> userToIp;

    private String serverIp;
    private String serverPort;

    private Socket serverSocket;



    public boolean isSocketClosed() {
        return serverSocket.isClosed();
    }

    public Map<String, String> getUserToIp() {
        return userToIp;
    }
}
