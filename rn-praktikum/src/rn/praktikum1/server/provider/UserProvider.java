package rn.praktikum1.server.provider;

import rn.helperlein.Databases;
import rn.praktikum1.server.mails.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created with IntelliJ IDEA.
 * User: abg628
 * Date: 28.03.13
 * Time: 18:12
 * To change this template use File | Settings | File Templates.
 */
public class UserProvider {

    static Connection connection;

    static Statement statement;

    static Connection getConnection() {
        if (connection == null) {
            connection = Databases.initializeSQLiteConnection("rnpr1");
        }

        return connection;
    }

    static Statement getStatement() {
        if (statement == null) {
            try {
                statement = getConnection().createStatement();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        return statement;
    }

    public static User getUserByUsername(String username) {

        //precondition blablabla

        String sql = "SELECT * FROM user WHERE username = '"+ username +"';";

        ResultSet resultSet = null;

        try {
            resultSet = getStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        User user = User.create("","");
        if (resultSet != null) {
            try {
                int userid = resultSet.getInt("userid");
                String pw = resultSet.getString("password");

                user = User.create(username,pw);
                user.setId(userid);

                getStatement().close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }


        return user;

    }

    public static void main(String[] args) {
        String user = "user";
        for (int i = 0; i < 20; i++) {
            System.out.println(getUserByUsername(user + i));
        }
    }

    public static Boolean login(User user, String password) {
        return user.getPassword().equals(password);
    }
}
