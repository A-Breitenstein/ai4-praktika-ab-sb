package rn.praktikum1.server.mails;

import java.io.Serializable;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class Message implements Serializable {

    private int id;
    private String content;
    private int size;
    private boolean valid;
    private String hash;

    private Message(int id, String content, int size, String hash, boolean valid) {
        this.id = id;
        this.content = content;
        this.size = size;
        this.valid = valid;
        this.hash = hash;
    }

    public static Message create(int id, String content,  int size, String hash, boolean valid) {
        return new Message(id, content, size, hash, valid);
    }


    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    public int getId() {
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
