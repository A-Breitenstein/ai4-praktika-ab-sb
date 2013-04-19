package rn.praktikum2.client;

import javax.swing.*;

/**
 * User: Alex
 * Date: 19.04.13
 * Time: 18:45
 */
public class Test {

    private ClientView clientView;


    public static void main(String[] args) {
        Test test = new Test();

        test.chatWindow();
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            test.clientView.displayMessage("Test "+i+", funzt das!?");
        }

    }


    public void chatWindow(){

        clientView = new ClientView();
        JFrame frame = new JFrame("ClientView");
        frame.setContentPane(clientView.getJPanelArea());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
