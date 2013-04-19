package rn.praktikum2.client;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * User: Alex
 * Date: 19.04.13
 * Time: 18:53
 */
public class ClientLogin {
    public JButton btn_login;
    public JTextField e_username;
    private JPanel loginForm;
    public JLabel l_info;
    private boolean done = false;
    private String username;
    public ChatClient chatClient;
    final private String usernameNA = "Name ist bereits vergeben";

    public ClientLogin(){
        e_username.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateButton(e_username);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateButton(e_username);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateButton(e_username);
            }
        });
        e_username.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                validateButton(e_username);
            }
        });
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: LOGIN validation
                username = e_username.getText();
                if (chatClient.evaluateUsername(username)) {
                    l_info.setText(username);
                    e_username.setEnabled(false);
                    btn_login.setEnabled(false);
                }else{
                    l_info.setText(usernameNA);
                }
            }
        });
    }

    private void validateButton(JTextField textField) {

        if (validUsername(textField))
            btn_login.setEnabled(true);
        else
            btn_login.setEnabled(false);

    }

    private boolean validUsername(JTextField textField) {
        String editFieldText = textField.getText();
        return !(editFieldText.isEmpty() || editFieldText.replace(" ", "").isEmpty() || editFieldText.length() > 5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ClientLogin");
        frame.setContentPane(new ClientLogin().loginForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getLoginform() {
        return loginForm;
    }

    public boolean done() {

        return done;
    }

    public String getUsername() {
        return username;
    }

    public void setChatClient(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
}
