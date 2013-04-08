package rn.praktikum1.server;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import rn.helperlein.Communication;
import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.states.Messages;
import rn.praktikum1.server.states.ServerState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;


import static rn.helperlein.Communication.warteNachricht;
import static rn.praktikum1.server.states.Messages.*;

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

    private Logger logger;

    private Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
        serverState = ServerState.AUTHORIZATION;
    }

    public void initLogger() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        lc.reset();
        configurator.setContext(lc);
        try {
//            configurator.doConfigure("D:\\Alex\\HAW\\AI-4\\RN\\rn-praktikum\\src\\rn\\praktikum1\\server\\logs\\byUserid.xml");
             configurator.doConfigure("/home/stud24/abg667/AI4/rn-praktikum/src/rn/praktikum1/server/logs/byUserid.xml");
//            configurator.doConfigure("C:\\Users\\Sven\\IdeaProjects\\rn-praktikum\\src\\rn\\praktikum1\\server\\logs\\byUserid.xml");
        } catch (JoranException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        this.logger = LoggerFactory.getLogger(Server.class);

        MDC.put("userid", "SERVER-user-" + user.getId());
        this.logger.debug("#Logger start");
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
            if(user != null)
                getLogger().info("Server -> Client: "+message);

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

                if(!serverState.equals(ServerState.UPDATE))
                    line = warteNachricht(clientSocket);

                if(user != null)
                    getLogger().info("Client -> Server: "+line);

                serverState.evaluate(this,line);


//                System.out.println("output " +clientSocket.isOutputShutdown() + " input: "+clientSocket.isInputShutdown());
//                System.out.println("connected " + clientSocket.isConnected());

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

            }

        }

        this.logger.debug("#"+Thread.currentThread().getName() + " : id: " +Thread.currentThread().getId() + " : beendet Serverinstanz: " + this);
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
            response += String.valueOf(indexOfMessage++) + WhiteSpace + message.getSize() + CRLF;
        }

        response += Point + CRLF;

        tellToClient(response);
    }

    public void closeSocket() {
        try {
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void responseLIST_MESSAGE_OK(int mailnumber, Message message) {
        String response = OK +" "+mailnumber+" "+message.getSize()+TerminationOctet;

        tellToClient(response);
    }

    public void responseUIDL(List<Message> messageList) {
        String response = "";
        int indexOfMessage = 1;

        for (Message message : messageList) {
            response += String.valueOf(indexOfMessage++) + WhiteSpace + message.getContent().hashCode() + CRLF;
        }

        response += Point + CRLF;

        tellToClient(response);
    }

    public void responseRETR(int mailId) {

        Message message = user.getMailById(mailId);

        final String response = message.getContent();
//        int i;
////        for (i = 0; (i+1)*498 < response.length() ; i++) {
//            tellToClient(response.substring(i*498,(i+1)*498)+ Messages.CRLF);
//        }
        tellToClient(response + TerminationOctet);

    }

    public Logger getLogger() {
        return logger;
    }
}
