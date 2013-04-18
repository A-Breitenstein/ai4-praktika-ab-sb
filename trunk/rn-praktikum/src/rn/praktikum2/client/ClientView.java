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
    private JPanel JPanelArea;
    private JTextArea w_chatWindow;
    private JTextField e_editFieldChat;
    private JButton btn_send;
    private JTextArea w_userWindow;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ClientView");
        frame.setContentPane(new ClientView().JPanelArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
