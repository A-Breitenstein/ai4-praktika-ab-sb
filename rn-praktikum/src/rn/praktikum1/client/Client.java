package rn.praktikum1.client;

import static rn.helperlein.Communication.*;

import java.io.IOException;
import java.net.Socket;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class Client {
   public static void connect(String ip,int port) {

       try {

           Socket socket = new Socket(ip,port);

           System.out.println("schicke 1. nachricht");
          schreibeNachricht(socket,"USER QWE123"+'\n');
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
          connect("127.0.0.1",55555);
    }
}
