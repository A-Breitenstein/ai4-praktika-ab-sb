package rn.praktikum1.server.mails;

import java.io.Serializable;
import java.util.List;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class User implements Serializable {

    private int id;

    private String username;

    private String password;

    private List<Message> userMails;

    private boolean delete;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.delete = false;
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

    /**
     * function already subtracts 1 vom mailNumber, no need for index correction
     *
     * @param mailNumber
     * @return
     */
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

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
