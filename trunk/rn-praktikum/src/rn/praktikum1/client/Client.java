package rn.praktikum1.client;

import rn.praktikum1.server.Command;
import rn.praktikum1.server.mails.User;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import static rn.helperlein.Communication.schreibeNachricht;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class Client {


    static List<UserDescriptor> userDescriptors;


    public static void connect(String ip, int port) {

        try {

            Socket socket = new Socket(ip, port);

            System.out.println("schicke 1. nachricht");
            schreibeNachricht(socket, "USER QWE123" + '\n');
            Thread.sleep(15000);

            System.out.println("schicke 2. nachricht");
            schreibeNachricht(socket, "quit" + '\n');

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    public static void main(String[] args) {
        connect("127.0.0.1", 55555);
        boolean running = true;
        String input = "";
        Command command;

        while (running) {

            //START BACKGROUND-UPDATER

            System.out.println("Befehl eingabe: LOGO,CNFG,QUIT");
            input = System.console().readLine();

            try {
                command = Command.valueOf(input.substring(0, 4));

                switch (command) {

                    case LOGO :{

                    }break;

                    case CNFG : {
                        configureUsers(userDescriptors);

                    }break;

                    case QUIT : {
                        running = !running;
                        saveUsers();
                    }break;

                    default:
                        System.out.println("BEFEHL NICHT BEIM CLIENT VORHANDEN!");

                }
            } catch (IllegalArgumentException iAE) {
                System.out.println("FALSCHE AUSGABE: "+input);
            }

        }
        System.out.println("Client beendet sich");
    }

    private static void configureUsers(List<UserDescriptor> userDescriptors) {
        boolean running = true;
        String in = "";


        while (running) {

            for (int i = 0; i < userDescriptors.size(); i++) {
                User user = userDescriptors.get(i).getUser();
                System.out.println("userID: " + i + " Username: "+user.getUsername()+" internalID: "+user.getId());
            }

            System.out.println("userID '#' für configuration des users oder 'exit' zum zurückkehren ins hauptmenü:");

            in = System.console().readLine();

            //TODO:usw.

        }

    }


    static void saveUsers() {

    }

    static void retrieveUsers() {

    }

}
