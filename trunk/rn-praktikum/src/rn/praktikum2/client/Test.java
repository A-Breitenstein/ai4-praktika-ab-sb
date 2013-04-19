package rn.praktikum2.client;

import javax.swing.*;

/**
 * User: Alex
 * Date: 19.04.13
 * Time: 18:45
 */
public class Test {

    private ClientView clientView;
    private ClientLogin clientLogin;


    public static void main(String[] args) {
        Test test = new Test();

        test.clientLogin();

        while (!test.clientLogin.done()) {
            System.out.println("wait for login");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        test.clientView();
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            test.clientView.displayMessage("Test " + i + ", funzt das!?");
        }

    }

    public void clientLogin() {

        clientLogin = new ClientLogin();
        JFrame frame = new JFrame("ClientLogin");
        frame.setContentPane(clientLogin.getLoginform());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    public void clientView(){

        clientView = new ClientView();
        JFrame frame = new JFrame("ClientView");
        frame.setContentPane(clientView.getJPanelArea());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
