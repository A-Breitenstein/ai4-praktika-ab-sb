package rn.praktikum1.server.mails;

import java.util.Map;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class User {

    private String username;

    private String password;

    private Map<Integer, Message> userMails;


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

    public Map<Integer, Message> getUserMails() {
        return userMails;
    }

    public void setUserMails(Map<Integer, Message> userMails) {
        this.userMails = userMails;
    }

    public Message getMailById(int id) {
        return getUserMails().get(id);
    }
}
