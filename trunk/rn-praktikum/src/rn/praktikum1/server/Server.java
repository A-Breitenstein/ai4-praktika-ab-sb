package rn.praktikum1.server;

import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.states.ServerState;

import java.io.*;
import java.net.Socket;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class Server implements Runnable{
    private static final int incoming_message_size = 40;

    private ServerState serverState;

    private User user;

    private Socket clientSocket;

    private Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
        serverState = ServerState.AUTHORIZATION;
    }


    //----------#Setter|Getter

    public ServerState getServerState() {
        return serverState;
    }

    public void setServerState(ServerState serverState) {
        this.serverState = serverState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void tellToClient(Message message) {
        //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public void run() {
        String input = "",line="";
        while (Thread.currentThread().isAlive() && !clientSocket.isClosed()) {
//            input = readInputstream();
            // Get input from the client
            try {
                InputStreamReader streamReader = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                System.out.println(reader.readLine());
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }



//            serverState.evaluate(this,input);
            System.out.println(input);
        }
    }

    private String readInputstream() {
        String message = "";
        try {
            char[] buffer = new char[incoming_message_size];
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            int anzahlZeichen = bufferedReader.read(buffer,0,incoming_message_size);
            message = String.valueOf(buffer,0,anzahlZeichen);
        }
        catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return message;
    }

    public static Server create(Socket clientSocket) {
        return new Server(clientSocket);
    }
}
