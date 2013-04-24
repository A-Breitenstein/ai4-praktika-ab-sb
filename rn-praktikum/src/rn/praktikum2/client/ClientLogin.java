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
    private JPanel loginForm;
    public JTextField e_username;
    private JTextField e_ipport;
    public JButton btn_login;
    private JButton btn_ipport;
    public JLabel l_info;
    private JLabel l_ipport;

    public ChatClient chatClient;
    private boolean done = false;

    private String username;
    private String ipport = "";

    final private String usernameNA = "Name ist bereits vergeben";
    final private String ipportINVALID = "Die Adresse ist inkorrekt";

    public ClientLogin(){
        e_username.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateButton(e_username, btn_login);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateButton(e_username, btn_login);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateButton(e_username, btn_login);
            }
        });
        e_username.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                validateButton(e_username, btn_login);
            }
        });
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: LOGIN validation
                if (!ipport.isEmpty()) {

                    username = e_username.getText();
                    if (chatClient.evaluateUsername(username)) {
                        l_info.setText(username);
                        e_username.setEnabled(false);
                        btn_login.setEnabled(false);
                    } else {
                        l_info.setText(usernameNA);
                    }
                }
            }
        });
        e_ipport.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateButton(e_ipport, btn_ipport);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateButton(e_ipport, btn_ipport);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateButton(e_ipport, btn_ipport);
            }
        });
        e_ipport.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                validateButton(e_username, btn_ipport);
            }
        });;
        btn_ipport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: LOGIN validation
                ipport = e_ipport.getText();
                if (chatClient.evaluateIpPort(ipport)) {
                    l_ipport.setText(ipport);
                    e_ipport.setEnabled(false);
                    btn_ipport.setEnabled(false);
                }else{
                    l_ipport.setText(ipportINVALID);
                }
            }
        });
    }

    private void validateButton(JTextField textField, JButton button) {

        if (validUsername(textField))
            button.setEnabled(true);
        else
            button.setEnabled(false);

    }

    private boolean validUsername(JTextField textField) {
        String editFieldText = textField.getText();
        return !(editFieldText.isEmpty() || editFieldText.replace(" ", "").isEmpty());
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
