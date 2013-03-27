package rn.praktikum1.simpeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 17:11
 */
public class SimpleServer {

    public static void main(String[] args) {

        int port = 55555;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();

            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while(inFromClient.ready())
            System.out.println(inFromClient.readLine());

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
