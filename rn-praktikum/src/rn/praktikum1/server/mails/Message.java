package rn.praktikum1.server.mails;

import java.io.Serializable;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class Message implements Serializable {

    private String id;
    private String content;
    private int size;
    private boolean valid;

    private Message(String id, String content, int size, boolean valid) {
        this.id = id;
        this.content = content;
        this.size = size;
        this.valid = valid;
    }


    private Message(String content, int size) {
        this.content = content;
        this.size = size;
    }

    public static Message create(String id, String content, int size, boolean valid) {
        return new Message(id, content, size, valid);
    }


    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    public String getId() {
        return id;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "" + this.getId() + " : " + this.getSize() + " : " + this.getContent() + " : valid: " + this.isValid();
    }

    public void setInvalid() {
        this.valid = false;
    }

    public void setValid() {
        this.valid = true;
    }
}
