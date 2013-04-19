package rn.praktikum2.client;

import rn.praktikum2.server.ChatCommands;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

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
    private DataOutputStream outToServer; // Ausgabestream zum Server
    private BufferedReader inFromServer;  // Eingabestream vom Server
    private String username;
    private ClientView clientView;
    private ClientLogin clientLogin;
    int port = 50000;


    Semaphore sem_validatedUsername = new Semaphore(0);

    public static void main(String[] args) {
        try {
            new ChatClient().startClient();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void startClient() throws InterruptedException {


        try {
            serverConnection = new ServerConnection(this,"127.0.0.1",port);
            listener = UdpListener.create(this, port);
            sender = UdpSender.create(this, port);
            inFromServer = new BufferedReader(new InputStreamReader(serverConnection.getServerSocket().getInputStream(),"UTF-8"));
            outToServer = new DataOutputStream(serverConnection.getServerSocket().getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }



        ui_login();
        clientLogin.setChatClient(this);

        sem_validatedUsername.acquire();

        ui_chat();
        clientView.setChatClient(this);

        new Thread(serverConnection).start();
        new Thread(listener).start();



    }

    private void ui_chat() {
        clientView = new ClientView();
        JFrame frame = new JFrame("ClientView");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sendBYE();
            }
        });
        frame.setContentPane(clientView.getJPanelArea());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void sendBYE() {
        writeToServer(ChatCommands.BYE.name());
    }

    private void ui_login() {
        clientLogin = new ClientLogin();
        JFrame frame = new JFrame("ClientLogin");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sendBYE();
            }
        });
        frame.setContentPane(clientLogin.getLoginform());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public boolean evaluateUsername(String username) {
        String line;
        writeToServer(ChatCommands.NEW + " " + username);
        line = readFromServer();

        if (line.contains(ChatCommands.OK.name())) {
            this.username = username;
            sem_validatedUsername.release(1);
            return true;
        }

        return false;
    }

    public void writeToServer(String request) {
    /* Sende den request-String als eine Zeile (mit newline) zum Server */
        try {
            outToServer.writeBytes(request + "\r\n");
        } catch (IOException e) {
            System.err.println(e.toString());
        }

        System.out.println(((username == null) ? ("unbekannt"): (username))+ ": sent to server: " + request);
    }

    public String readFromServer() {
    /* Liefere die Antwort (reply) vom Server */
        String reply = "";

        try {
            reply = inFromServer.readLine();
        } catch (IOException e) {
            System.err.println("Connection aborted by server!");
        }
        System.out.println(((username == null) ? ("unbekannt"): (username)) + ": got from Server: " + reply);
        return reply;
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


    public void displayUsers(List<String> users) {

        clientView.displayUsers(users);
    }

    public void displayMessage(String message) {
        clientView.displayMessage(message);
    }

    public void sendMessage(String message) {
        sender.sendMessage(message);
    }
}
