package rn.praktikum1.simpeltest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 17:11
 */
public class SimpleClient {


    public static void main(String[] args) {

        Socket socket = null;
        try {
            System.out.println("T".equals("T ".replace(" ","")));
            socket = new Socket("127.0.0.1", 55555);

            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

            outToServer.writeBytes("USER asdwa1" +'\n'+"."+'\n');

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }




}
