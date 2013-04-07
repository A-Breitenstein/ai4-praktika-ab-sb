package rn.praktikum1.client;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.provider.MailProvider;
import rn.praktikum1.server.states.Messages;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Logger logger;

    public ClientRunner(UserDescriptor userDescriptor) {
        this.userDescriptor = userDescriptor;
    }

    public void initLogger() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        lc.reset();
        configurator.setContext(lc);
        try {
            configurator.doConfigure("D:\\Alex\\HAW\\AI-4\\RN\\rn-praktikum\\src\\rn\\praktikum1\\server\\logs\\byUserid.xml");
        } catch (JoranException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        this.logger = LoggerFactory.getLogger(ClientRunner.class);

        MDC.put("userid", "CLIENT-user-" + userDescriptor.getUser().getId());
        this.logger.debug("#Logger start");
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
                                    for (List<String> mail_id : checkUIDs()) {
                                        //mail_id.get(0) = RETR id
                                        //mail_id.get(1) = UID
                                        saveEmail(mail_id.get(0),mail_id.get(1));
                                    }

                                } else {

                                    writeToServer("STAT");
                                    response = readFromServer();
                                    String[] parts = response.trim().split(" ");
                                    int message_count = Integer.valueOf(parts[1]);
                                    for (int i = 1; i <= message_count; i++) {
                                        saveEmail(String.valueOf(i),null);

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

    private List<List<String>> checkUIDs() {
        String response = "";
        String[] strings;
        List<List<String>> mail_ids = new ArrayList<List<String>>();

        while (!response.equals(".")) {
            response = readFromServer();
            strings = response.trim().split(" ");

            // strings[0] = die RETR id
            // strings[1] = die UID der Mail
            if (strings.length == 2 && ( !MailProvider.mailAlreadyExsists(strings[1], userDescriptor.getUser()) )) {
                userDescriptor.getUID_map().put(strings[1], strings[1]);
                mail_ids.add(Arrays.asList(strings[0],strings[1]));
            }
        }

        return mail_ids;

    }

    private void saveEmail(String retr_id,String uid) {
        String response;
        String content;
        writeToServer("RETR " + retr_id);
        response = readFromServer();
        if (response.contains(Messages.OK)) {
            try {
                StringBuilder sb = new StringBuilder("");
                fileWriter.write("############ " + Client.dateFormat.format(Client.cal.getTime()) + " ############## \r\n");

                while (!response.equals(".")) {
                    response = readFromServer();
                    fileWriter.write(response + "\r\n");
                    sb.append(response);
                    fileWriter.flush();

                }

                content = sb.toString();
                if (uid == null) {
                    uid = String.valueOf(content.hashCode());
                }

                //TODO:
                /*
                MailProvider.saveMail(userDescriptor.getUser(), Message.create(uid,content,content.length(),true));
                 */
                MailProvider.addNewMessageToUser(
                        userDescriptor.getUser(),
                        Message.create(uid,content,content.length(),true)
                );
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
        System.out.println(userDescriptor.getUser().getUsername()+": sent the message: " + request);
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
        System.out.println(userDescriptor.getUser().getUsername()+": got from Server: " + reply);
        return reply;
    }

    public Logger getLogger() {
        return logger;
    }
}
