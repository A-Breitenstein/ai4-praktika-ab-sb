package rn.praktikum1.client;

import rn.helperlein.Communication;
import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.states.Messages;
import sun.reflect.generics.tree.FieldTypeSignature;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * User: Alex
 * Date: 04.04.13
 * Time: 14:07
 */
public class ClientRunner implements Runnable {

    private UserDescriptor userDescriptor;
    private Socket socket;
    private DataOutputStream outToServer; // Ausgabestream zum Server
    private BufferedReader inFromServer;  // Eingabestream vom Server
    private FileWriter fileWriter;

    public ClientRunner(UserDescriptor userDescriptor) {
        this.userDescriptor = userDescriptor;
    }


    @Override
    public void run() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        while (true) {

            try {
                socket = new Socket(userDescriptor.getServerIp(), userDescriptor.getServerPort());
                outToServer = new DataOutputStream(socket.getOutputStream());
                inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                fileWriter = new FileWriter(userDescriptor.getUser().getUsername() + ".txt", true);
                Calendar cal = Calendar.getInstance();

                String response = readFromServer();
                if (response.contains(Messages.OK)) {
                    writeToServer("USER " + userDescriptor.getUser().getUsername());
                    response = readFromServer();
                    if (response.contains(Messages.OK)) {
                        writeToServer("PASS " + userDescriptor.getUser().getPassword());
                        response = readFromServer();
                        if (response.contains(Messages.OK)) {
                            writeToServer("STAT");
                            response = readFromServer();
                            String[] parts = response.trim().split(" ");
                            int message_count = Integer.valueOf(parts[1]);
                            for (int i = 1; i <= message_count; i++) {

                                writeToServer("RETR " + i);
                                response = readFromServer();
                                if (response.contains(Messages.OK)) {
                                    fileWriter.write("############ "+dateFormat.format(cal.getTime())+" ############## \r\n");
                                    while (!response.equals(".")) {
                                        response = readFromServer();
                                        fileWriter.write(response+"\r\n");
                                        fileWriter.flush();

                                    }
                                }
                            }

                            writeToServer("QUIT");
                            response = readFromServer();
                            if (response.contains(Messages.OK)) {
                                outToServer.close();
                                inFromServer.close();
                                socket.close();
                                fileWriter.close();
                            }

                        }
                    }
                }

                Thread.sleep(30000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ClientRunner(UserDescriptor.create(User.create("user2", "pw2"), "127.0.0.1", 11000)).run();
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
