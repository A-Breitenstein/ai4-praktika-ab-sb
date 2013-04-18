package rn.praktikum2.client;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: abg667
 * Date: 18.04.13
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
public class ClientView extends JFrame {
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea2;


    public static void main(String[] args) {
        JFrame frame = new ClientView();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showGUI() {
        getContentPane().add(textArea1);
        getContentPane().add(textArea2);
        getContentPane().add(textField1);
        getContentPane().add(button1);

    }
}
