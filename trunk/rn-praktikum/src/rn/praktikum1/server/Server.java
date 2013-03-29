package rn.praktikum1.server;

import rn.helperlein.Communication;
import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.states.ServerState;

import static rn.helperlein.Communication.warteNachricht;
import static rn.praktikum1.server.states.Messages.*;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    Logger logger;

    private Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
        serverState = ServerState.AUTHORIZATION;
        this.logger = Logger.getLogger(clientSocket.toString());
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

    public void tellToClient(String message) {
        try {
            Communication.schreibeNachricht(clientSocket,message);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void run() {
        String line="";

        responseOK();
        while (!clientSocket.isClosed() && !Thread.currentThread().isInterrupted()) {

            try {

                line = warteNachricht(clientSocket);

                serverState.evaluate(this,line);

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

            }

        }


            System.out.println(Thread.currentThread().getName() + " : id: " +Thread.currentThread().getId() + " : beendet Serverinstanz: " + this);
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

    public void changeServerStateToAUTHORIZATION() {
        this.getServerState().changeServerStateToAUTHORIZATION(this);
    }

    public void changeServerStateToTRANSACTION() {
        this.getServerState().changeServerStateToTRANSACTION(this);
    }

    public void changeServerStateToUPDATE() {
        this.getServerState().changeServerStateToUPDATE(this);
    }

    public void responseOK() {
        tellToClient(OK+CRLF);
    }

    public void responseOK(int... parameters) {
        String response = OK;

        for (int parameter : parameters) {
            response += WhiteSpace + parameter;
        }

        response += CRLF;

        tellToClient(response);
    }
    public void responseError() {
        tellToClient(ERR+CRLF);
    }

    public void responseLISTOK(List<Message> messageList) {
        String response = "";
        int indexOfMessage = 1;

        for (Message message : messageList) {
            response += String.valueOf(indexOfMessage++) + message.getSize() + '\n';
        }

        response += TerminationOctet + '\n' + CRLF;

        tellToClient(response);
    }

    public void closeSocket() {
        try {
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void responseLIST_MESSAGE_OK(Message message) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
