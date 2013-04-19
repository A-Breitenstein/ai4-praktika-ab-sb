package rn.praktikum2.client;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;

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
    private JScrollPane scrollpanel;
    public ChatClient chatClient;



    public ClientView() {
        e_editFieldChat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateButton(e_editFieldChat);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateButton(e_editFieldChat);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateButton(e_editFieldChat);
            }
        });
        e_editFieldChat.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                validateButton(e_editFieldChat);
            }
        });
        e_editFieldChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMessageToTextareaFromEditfield(w_chatWindow, e_editFieldChat);
            }
        });
        btn_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMessageToTextareaFromEditfield(w_chatWindow, e_editFieldChat);
            }
        });


    }

    private void displayMessageToTextareaFromEditfield(JTextArea textArea, JTextField textField) {
        if (!emptyEditField(textField)) {
            String text = textField.getText();
//            appendTextToTextarea(text, textArea);
            chatClient.sendMessage(text);
            clearTextfield(textField);
        }
    }

    private void appendTextToTextarea(String text, JTextArea textArea) {
        textArea.append(text + "\n");
    }

    private void clearTextfield(JTextField textField) {
        textField.setText("");
    }

    private boolean emptyEditField(JTextField textField) {
        String editFieldText = textField.getText();
        return editFieldText.isEmpty() || editFieldText.replace(" ", "").isEmpty();
    }

    private void validateButton(JTextField textField) {

        if (emptyEditField(textField))
            btn_send.setEnabled(false);
        else
            btn_send.setEnabled(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("clientView");
        frame.setContentPane(new ClientView().JPanelArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public JPanel getJPanelArea() {
        return JPanelArea;
    }

    public void displayMessage(String message) {
        w_chatWindow.append(message + "\n");
    }

    public void displayUsers(List<String> user) {

        w_userWindow.setText("");
        for (String username : user) {
            w_userWindow.append(username + "\n");
        }
    }

    public void setChatClient(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
}
