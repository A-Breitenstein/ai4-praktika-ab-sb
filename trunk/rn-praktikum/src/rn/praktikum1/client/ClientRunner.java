package rn.praktikum1.client;

import rn.helperlein.Communication;
import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.states.Messages;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * User: Alex
 * Date: 04.04.13
 * Time: 14:07
 */
public class ClientRunner implements Runnable {

    UserDescriptor userDescriptor;
    Socket socket;
    private DataOutputStream outToServer; // Ausgabestream zum Server
    private BufferedReader inFromServer;  // Eingabestream vom Server

    public ClientRunner(UserDescriptor userDescriptor) {
        this.userDescriptor = userDescriptor;
        try {
            socket = new Socket(userDescriptor.getServerIp(), userDescriptor.getServerPort());
            outToServer = new DataOutputStream(socket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

        try {
            String response = readFromServer();
            if (response.equals(Messages.OK)) {
                writeToServer("USER " + userDescriptor.getUser().getUsername());
                response = readFromServer();
                if (response.equals(Messages.OK)) {
                    writeToServer("PASS " + userDescriptor.getUser().getPassword());
                    response = readFromServer();
                    if (response.equals(Messages.OK)) {
                        writeToServer("STAT");
                        response = readFromServer();
                        String[] parts = response.trim().split(" ");
                        int message_count = Integer.valueOf(parts[1]);
                        for (int i = 1; i <= message_count; i++) {

                            writeToServer("RETR " + i);
                            response = readFromServer();
                            if (response.equals(Messages.OK)) {
                                while (!response.equals(".")) {
                                    response = readFromServer();
                                    System.out.println(response);
                                }
                            }
                        }

                    }
                }
            }

            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientRunner(UserDescriptor.create(User.create("user1", "pw1"), "127.0.0.1", 11000)).run();
    }

    private void writeToServer(String request) {
    /* Sende den request-String als eine Zeile (mit newline) zum Server */
        try {
            outToServer.writeBytes(request + '\n');
        } catch (IOException e) {
            System.err.println(e.toString());
//            serviceRequested = false;
        }
        System.out.println("TCP Client has sent the message: " + request);
    }

    private String readFromServer() {
    /* Liefere die Antwort (reply) vom Server */
        String reply = "";

        try {
            reply = inFromServer.readLine();
        } catch (IOException e) {
            System.err.println("Connection aborted by server!");
//            serviceRequested = false;
        }
        System.out.println("TCP Client got from Server: " + reply);
        return reply;
    }

}
