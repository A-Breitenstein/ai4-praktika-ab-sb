package rn.praktikum1.client;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
           schreibeNachricht(socket,"USER QWE123");

           Thread.sleep(1000000);
       } catch (IOException e) {
           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
       } catch (InterruptedException e) {
           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
       }
   }

    public static void main(String[] args) {
          connect("127.0.0.1",55555);
    }
    static void  schreibeNachricht(java.net.Socket socket, String nachricht) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.print(nachricht);
    }
}
