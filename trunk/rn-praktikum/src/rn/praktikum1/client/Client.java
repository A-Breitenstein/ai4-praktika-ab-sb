package rn.praktikum1.client;

import rn.praktikum1.server.Command;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.provider.UserProvider;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class Client {

    static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Calendar cal = Calendar.getInstance();
    static List<UserDescriptor> userDescriptors;
    final static String users_filename = "users.ser";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Thread> running_threads = new ArrayList<Thread>();

    public static Socket connect(String ip, int port) {

        Socket socket = null;

        try {

            socket = new Socket(ip, port);

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return socket;
    }

    public static String getInput() {
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void main(String[] args) {

        // loading userDescriptors
        userDescriptors = retrieveUsers();

        if(userDescriptors != null) {
            for (UserDescriptor userDescriptor : userDescriptors) {
                running_threads.add(new Thread(new ClientRunner(userDescriptor)));
            }
            for (Thread running_thread : running_threads) {
                running_thread.start();
            }
        }

        boolean running = true;
        String input = "";
        Command command;

        System.out.println("Willkommen zum RNP Mail-Client");

        while (running) {

            //START BACKGROUND-UPDATER
            System.out.println("Befehl eingabe: CNFG,QUIT");

            try {
                input = getInput();
                command = Command.valueOf(input.substring(0, 4));

                switch (command) {

                    case CNFG: {
                        configureUsers(userDescriptors);

                    }
                    break;

                    case QUIT: {
                        running = !running;
                        for (Thread running_thread : running_threads) {
                            running_thread.interrupt();
                        }
                        for (Thread running_thread : running_threads) {
                            try {
                                running_thread.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        saveUsers(userDescriptors);

                    }
                    break;

                    default:
                        System.out.println("BEFEHL NICHT BEIM CLIENT VORHANDEN!");

                }
            } catch (IllegalArgumentException iAE) {
                System.out.println("FALSCHE EINGABE: " + input);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("FALSCHE EINGABE: " + input);
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
                System.out.println("userID: " + (i+1) + " Username: " + user.getUsername() + " internalID: " + user.getId());
            }

            System.out.println("userID '#' für configuration des users oder 'EXIT' zum zurückkehren ins hauptmenü:");

            System.out.println("USER 'IDNummer' für bearbeitung, MAKE für üser erstellung, EXIT zum beenden");


            try {

                in = getInput();

                String strCommandIn = in.substring(0, 4);
                String strContentIn = "";

                if (in.length() >= 5) {
                    strContentIn = in.substring(5);
                }

                final Command commandIn = Command.valueOf(strCommandIn);

                switch (commandIn) {

                    case USER: {
                        try {
                            int userid = Integer.valueOf(strContentIn);

                            if (userid >= 0 && userid < userDescriptors.size()) {
                                UserDescriptor userDescriptor = userDescriptors.get(userid - 1);
                                User user = userDescriptor.getUser();

                                String username, password, ip, port="";
                                int intPort = 0;

                                System.out.println("User: " + user.getUsername() + " Id: " + user.getId());
                                System.out.println("Passwort: " + user.getPassword());
                                System.out.println("Server-ip:port > " + userDescriptor.getServerIp() + ":" + userDescriptor.getServerPort());

                                System.out.println("Eingabe hat nach Schema zu erfolgen!");
                                System.out.println("Leere eingaben werden missachtet und der wert wird nicht verändert, leerzeichen sind nicht erlaubt");
                                System.out.println("Eingaben mit Return abschließen!");

                                //Username
                                System.out.println("Neuer Username:");
                                username = getInput();

                                //password
                                System.out.println("Neues Passwort:");
                                password = getInput();

                                //ip
                                System.out.println("Neue Server-ip:");
                                ip = getInput();


                                boolean portIsInt = false;
                                while (!portIsInt) {
                                    //port
                                    System.out.println("Neuer Server-port:");
                                    port = getInput();
                                    if (!port.isEmpty()) {
                                        try {
                                            intPort = Integer.valueOf(port);
                                            portIsInt = !portIsInt;
                                        } catch (IllegalArgumentException iAE) {
                                            System.out.println("server-Port ist kein gültiger Int wert!!!!!");
                                        }
                                    } else {
                                        portIsInt = !portIsInt;
                                    }
                                }

                                if(!username.isEmpty() || !password.isEmpty() || !ip.isEmpty() || !port.isEmpty()) {

                                    if (username.isEmpty()) {
                                        username = user.getUsername();
                                    }

                                    if (password.isEmpty()) {
                                        password = user.getPassword();
                                    }

                                    if (ip.isEmpty()) {
                                        ip = userDescriptor.getServerIp();
                                    }

                                    if (port.isEmpty()) {
                                        intPort = userDescriptor.getServerPort();
                                    }

                                    System.out.println("Neu -> Username, Passwort, ip, port");
                                    System.out.println("Neu -> " + username + ", " + password + ", " + ip + ", " + intPort);

                                    System.out.println("übernehmen? Ja:j, Nein:n");
                                    in = getInput();

                                    if (in.equals("j")) {

                                        System.out.println("Neue Werte werden übernommen!");

                                        user.setUsername(username);
                                        user.setPassword(password);

                                        UserProvider.updateUser(user);

                                        userDescriptor.setServerIp(ip);
                                        userDescriptor.setServerPort(intPort);

                                        saveUsers(userDescriptors);

                                    } else if (in.equals("n")) {

                                        System.out.println("Neue Werte werden verworfen");

                                    } else {
                                        System.out.println("Eingabe nicht erkannt, neue Werte werden verworfen");
                                    }
                                }else{
                                    System.out.println("Werte sind alle leer, keine änderung vorgenommen");
                                }

                            } else {
                                System.out.println("UserId " + userid + " liegt ausserhalb des legalen bereiches");
                            }


                        } catch (IllegalArgumentException iAE) {

                            System.out.println("Eingabe ist kein gültiger integer wert!");
                        }

                    }
                    break;
                    case MAKE: {

                        System.out.println("Benutzererstellung:");
                        System.out.println("Schema: Username,Passwort,server-ip,server-port");
                        System.out.println("Trennung erfolgt zwangsweise durch Komma, keine leerzeichen erlaubt!");
                        System.out.println("Username,Passwort,server-ip,server-port:");


                        in = getInput();
                        String userStrings[] = in.split(",");

                        User user = User.create(userStrings[0], userStrings[1]);
                        UserProvider.createUser(user);
                        UserDescriptor userDescriptor = UserDescriptor.create(user, userStrings[2], Integer.valueOf(userStrings[3]));

                        userDescriptors.add(userDescriptor);

                        saveUsers(userDescriptors);
                        Thread thread = new Thread(new ClientRunner(userDescriptor));
                        thread.start();
                        running_threads.add(thread);

                    }
                    break;
                    case APOP:

                    case EXIT : {
                         return;
                    }
                }


            } catch (IllegalArgumentException iAE) {

            }


        }

    }


    static void saveUsers(List<UserDescriptor> userDescriptors) {
       // TODO hier sollten jetz eigentlich die user in der DB gespeichert werden
        //TODO: Ein User wird bei erstellung bereits persistiert, es werden id, name und password gepseichert
        //TODO: Im UserDescriptor stehen die ip und port
        try {
            FileOutputStream fileOut = new FileOutputStream(users_filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(userDescriptors);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    static List<UserDescriptor> retrieveUsers() {
        // TODO hier sollten jetzt eigentlich die user aus der DB geholt werden

        List<User> users = UserProvider.getAllUsers();

        List<UserDescriptor> userDescriptors = null;
        if (Files.exists(Paths.get(users_filename))) {
            try {
                FileInputStream fileIn = new FileInputStream(users_filename);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                userDescriptors = (List<UserDescriptor>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.println(UserDescriptor.class + " not found");
                c.printStackTrace();
            }
        } else {
            return new ArrayList<UserDescriptor>();
        }

        return userDescriptors;
    }

}
