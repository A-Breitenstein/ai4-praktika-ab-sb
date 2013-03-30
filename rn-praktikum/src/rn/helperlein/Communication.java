package rn.helperlein;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: abg628
 * Date: 28.03.13
 * Time: 18:27
 * To change this template use File | Settings | File Templates.
 */
public class Communication {
    public static void  schreibeNachricht(Socket socket, String nachricht) throws IOException {
        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
        outToServer.writeBytes(nachricht);
        System.out.println("Server -> Client: " +nachricht);
    }
    public static String  warteNachricht(Socket socket) throws IOException {
        BufferedReader inFromClient =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final String line = inFromClient.readLine();
        System.out.println("Client -> Server: "+line);
        return line;
    }
}
