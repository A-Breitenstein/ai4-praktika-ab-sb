package rn.praktikum1.server.mails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class User {

    private int id;

    private String username;

    private String password;

    private List<Message> userMails;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static User create(String username, String password) {
        return  new User(username,password);
    }

    //----------#Getter|Setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getUserMails() {
        return userMails;
    }

    public void setUserMails(List<Message> userMails) {
        this.userMails = userMails;
    }

    public int getNumberOfMails() {
        final int numberOfMails = getUserMails().size();

        return numberOfMails;
    }

    public int getMessagesSize() {
        int messagesSize = 0;

        for (Message message : getUserMails()) {
            messagesSize += message.getSize();
        }

        return messagesSize;
    }

    public Message getMailById(Integer mailNumber) {

        final int mailNumberIndex = mailNumber -1;

        final Message message = getUserMails().get(mailNumberIndex);

        return message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final String print = "" + this.getId() + " : " + this.getUsername() + " : " +this.getPassword();
        return print;
    }
}
