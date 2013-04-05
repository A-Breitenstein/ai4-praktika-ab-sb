package rn.praktikum1.client;

import rn.praktikum1.server.mails.User;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Alex
 * Date: 04.04.13
 * Time: 14:11
 */
public class UserDescriptor implements Serializable {

    private User user;
    private String serverIp;
    private int serverPort;
    private Socket socket;
    private Map<String, String> UID_map;


    private UserDescriptor(User user, String serverIp, int serverPort) {
        this.user = user;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = socket;
    }

    public static UserDescriptor create(User user, String serverIp, int serverPort) {
        return new UserDescriptor(user, serverIp, serverPort);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Map<String, String> getUID_map() {
        if (UID_map == null) {
            UID_map = new HashMap<String, String>();
        }
        return UID_map;
    }
}
