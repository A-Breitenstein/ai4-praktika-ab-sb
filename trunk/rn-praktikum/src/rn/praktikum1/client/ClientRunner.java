package rn.praktikum1.client;

import rn.praktikum1.server.mails.User;

/**
 * User: Alex
 * Date: 04.04.13
 * Time: 14:07
 */
public class ClientRunner implements Runnable {

    UserDescriptor userDescriptor;


    public ClientRunner(UserDescriptor userDescriptor) {
        this.userDescriptor = userDescriptor;
    }

    @Override
    public void run() {

    }
}
