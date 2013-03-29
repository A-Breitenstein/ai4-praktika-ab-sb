package rn.praktikum1.server.provider;

import rn.praktikum1.server.mails.User;

/**
 * Created with IntelliJ IDEA.
 * User: abg628
 * Date: 28.03.13
 * Time: 18:12
 * To change this template use File | Settings | File Templates.
 */
public class UserProvider {

    public static User findUser(String username) {
        return User.create("TestUser","pw");
    }

    public static Boolean login(User user, String password) {
        return user.getPassword().equals(password);
    }
}
