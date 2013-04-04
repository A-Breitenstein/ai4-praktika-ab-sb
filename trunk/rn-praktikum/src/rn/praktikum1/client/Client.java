package rn.praktikum1.client;

import rn.praktikum1.server.Command;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.provider.UserProvider;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class Client {


    static List<UserDescriptor> userDescriptors;


    public static Socket connect(String ip, int port) {

        Socket socket = null;

        try {

            socket = new Socket(ip, port);

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return socket;
    }


    public static void main(String[] args) {

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

                    case CNFG : {
                        configureUsers(userDescriptors);

                    }break;

                    case QUIT : {
                        running = !running;
                        saveUsers(userDescriptors);
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

            System.out.println("USER 'IDNummer' für bearbeitung, MAKE für üser erstellung");


            try {

                in = System.console().readLine();

                String strCommandIn = in.substring(0, 4);
                String strContentIn = "";

                if (in.length() >= 5) {
                    strContentIn = in.substring(5);
                }

                final Command commandIn = Command.valueOf(strCommandIn);

                switch (commandIn) {

                    case USER :{
                        try {
                            int userid = Integer.valueOf(strContentIn);

                            if (userid > 0 && userid < userDescriptors.size()) {
                                UserDescriptor userDescriptor = userDescriptors.get(userid - 1);
                                User user = userDescriptor.getUser();

                                String username, password, ip, port;
                                int intPort = 0;

                                System.out.println("User: " + user.getUsername() + " Id: " + user.getId());
                                System.out.println("Passwort: " + user.getPassword());
                                System.out.println("Server-ip:port > "+userDescriptor.getServerIp()+":"+userDescriptor.getServerPort());

                                System.out.println("Eingabe hat nach Schema zu erfolgen!");
                                System.out.println("Leere eingaben werden missachtet und der wert wird nicht verändert, leerzeichen sind nicht erlaubt");
                                System.out.println("Eingaben mit Return abschließen!");

                                //Username
                                System.out.println("Neuer Username:");
                                username = System.console().readLine();

                                //password
                                System.out.println("Neues Passwort:");
                                password = System.console().readLine();

                                //ip
                                System.out.println("Neue Server-ip:");
                                ip = System.console().readLine();


                                boolean portIsInt = false;
                                while (!portIsInt) {
                                    //port
                                    System.out.println("Neuer Server-port:");
                                    port = System.console().readLine();

                                    try {
                                        intPort = Integer.valueOf(port);
                                        portIsInt = !portIsInt;
                                    } catch (IllegalArgumentException iAE) {
                                        System.out.println("server-Port ist kein gültiger Int wert!!!!!");
                                    }
                                }

                                System.out.println("Neu -> Username, Passwort, ip, port");
                                System.out.println("Neu -> "+username+", "+password+", "+ip+", "+intPort);

                                System.out.println("übernehmen? Ja:j, Nein:n");
                                in = System.console().readLine().toLowerCase();

                                if (in.equals("ja")) {

                                    System.out.println("Neue Werte werden übernommen!");

                                    user.setUsername(username);
                                    user.setPassword(password);

                                    UserProvider.updateUser(user);

                                    userDescriptor.setServerIp(ip);
                                    userDescriptor.setServerPort(intPort);

                                    saveUsers(userDescriptors);

                                }else if (in.equals("nein")) {

                                    System.out.println("Neue Werte werden verworfen");

                                }else{
                                    System.out.println("Eingabe nicht erkannt, neue Werte werden verworfen");
                                }

                            }else{
                                System.out.println("UserId "+ userid +" liegt ausserhalb des legalen bereiches");
                            }


                        } catch (IllegalArgumentException iAE) {

                            System.out.println("Eingabe ist kein gültiger integer wert!");
                        }

                    }break;
                    case MAKE :{

                        System.out.println("Benutzererstellung:");
                        System.out.println("Schema: Username,Passwort,server-ip,server-port");
                        System.out.println("Trennung erfolgt zwangsweise durch Komma, keine leerzeichen erlaubt!");
                        System.out.println("Username,Passwort,server-ip,server-port:");



                        in = System.console().readLine();
                        String userStrings[] = in.split(",");

                        User user = User.create(userStrings[0], userStrings[1]);

                        UserProvider.createUser(user);
                        UserDescriptor userDescriptor = UserDescriptor.create(user, userStrings[2], Integer.valueOf(userStrings[3]));

                        userDescriptors.add(userDescriptor);

                        saveUsers(userDescriptors);

                    }break;

                }





            } catch (IllegalArgumentException iAE) {

            }


        }

    }


    static void saveUsers(List<UserDescriptor> userDescriptors) {
        //TODO:SAVE TO FILE

    }

    static void retrieveUsers() {
        //TODO:LOAD FROM FILE
    }

}
