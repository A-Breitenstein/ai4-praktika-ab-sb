package rn.praktikum1.client;

import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.states.Messages;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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


        while (true) {

            try {
                socket = new Socket(userDescriptor.getServerIp(), userDescriptor.getServerPort());

                if(socket.isConnected()){

                    outToServer = new DataOutputStream(socket.getOutputStream());
                    inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    fileWriter = new FileWriter(userDescriptor.getUser().getUsername() + ".txt", true);


                    String response = readFromServer();
                    if (response.contains(Messages.OK)) {
                        writeToServer("USER " + userDescriptor.getUser().getUsername());
                        response = readFromServer();
                        if (response.contains(Messages.OK)) {
                            writeToServer("PASS " + userDescriptor.getUser().getPassword());
                            response = readFromServer();
                            if (response.contains(Messages.OK)) {

                                writeToServer("UIDL");
                                response = readFromServer();
                                if (response.contains(Messages.OK)) {
                                    for (String mail_id : checkUIDs()) {
                                        saveEmail(mail_id);
                                    }

                                } else {

                                    writeToServer("STAT");
                                    response = readFromServer();
                                    String[] parts = response.trim().split(" ");
                                    int message_count = Integer.valueOf(parts[1]);
                                    for (int i = 1; i <= message_count; i++) {
                                        saveEmail(String.valueOf(i));

                                    }
                                }


                                writeToServer("QUIT");
                                response = readFromServer();
                                if (response.contains(Messages.OK)) {
                                    cleanUp();
                                }

                            }
                        }
                    }

                    Thread.sleep(30000);
                }else{
                    System.out.println("Der Server : "+userDescriptor.getServerIp()+":"+userDescriptor.getServerPort()+" ist nicht erreichbar!");
                    return;
                }


            } catch (InterruptedException e) {
                cleanUp();
                return;
            } catch (IOException e) {
                System.out.println("Der Server: "+userDescriptor.getServerIp()+":"+userDescriptor.getServerPort()+" ist nicht erreichbar!");
                cleanUp();
                return;
            }
        }
    }

    public static void main(String[] args) {
        new ClientRunner(UserDescriptor.create(User.create("user2", "pw2"), "127.0.0.1", 11000)).run();
    }

    private void cleanUp() {
        try {
            if(outToServer != null)
                outToServer.close();
            if(inFromServer != null)
                inFromServer.close();
            if(socket != null)
                socket.close();
            if(fileWriter != null)
                fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> checkUIDs() {
        String response = "";
        String[] strings;
        List<String> mail_ids = new ArrayList<String>();

        while (!response.equals(".")) {
            response = readFromServer();
            strings = response.trim().split(" ");
            if (strings.length == 2 && userDescriptor.getUID_map().get(strings[1]) == null) {
                userDescriptor.getUID_map().put(strings[1], strings[1]);
                mail_ids.add(strings[0]);
            }
        }

        return mail_ids;

    }

    private void saveEmail(String id) {
        String response;
        writeToServer("RETR " + id);
        response = readFromServer();
        if (response.contains(Messages.OK)) {
            try {
                fileWriter.write("############ " + Client.dateFormat.format(Client.cal.getTime()) + " ############## \r\n");

                while (!response.equals(".")) {
                    response = readFromServer();
                    fileWriter.write(response + "\r\n");
                    fileWriter.flush();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
