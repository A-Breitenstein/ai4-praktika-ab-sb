package rn.praktikum1.server.provider;

import rn.helperlein.Databases;
import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Alex
 * Date: 29.03.13
 * Time: 02:45
 */
public class MailProvider {

//    static Connection connection;
//
//    static Statement statement;

    static Connection getConnection() {
//        if (connection == null) {
//            connection = Databases.initializeSQLiteConnection("rnpr1");
//        }
//
//        return connection;
        return Databases.connection;
    }

    static Statement getStatement() {
//        if (statement == null) {
//            try {
//                statement = getConnection().createStatement();
//            } catch (SQLException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//            }
//        }
//
//        return statement;
        return Databases.getStatement();
    }

    public static List<Message> getMessagesByUser(User user) {

        List<Message> messages = new ArrayList<Message>();
        ResultSet resultSet;
        Message message;
        String text, hash;
        int id;
        boolean valid = true;

        String sql = "SELECT * FROM mail WHERE userid = "+ user.getId() +" ;";

        try {
            resultSet = getStatement().executeQuery(sql);


            while (resultSet.next()) {
                id = resultSet.getInt("mailid");
                text = resultSet.getString("message");
                hash = resultSet.getString("hash");
                message = Message.create(id, text, text.length(), hash, valid);
                messages.add(message);
            }

            getStatement().close();

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return messages;
    }

    public static void deleteMailById(Message message) {

        //precondition blablabla

        String sql = "DELETE FROM mail WHERE mailid = "+message.getId()+";";
        try {
            getStatement().execute(sql);
            getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void deleteAllMailById(List<Message> messages) {
        for (Message message : messages) {
            deleteMailById(message);
        }
    }

    public static void main(String[] args) {

        String sql = "SELECT * FROM mail WHERE hash IS NULL";

        try {
            ResultSet resultSet = getStatement().executeQuery(sql);

            while (resultSet.next()) {

                sql = "UPDATE mail SET hash ='"+String.valueOf(resultSet.getString("message").hashCode())+"' WHERE mailid="+resultSet.getInt("mailid")+";";
                getStatement().execute(sql);

            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void addMessagesToUser(User user) {
        List<Message> messages = MailProvider.getMessagesByUser(user);
        user.setUserMails(messages);
    }

    @Deprecated
    public static void addNewMessageToUser(User user, Message message) {

        String sql = "SELECT MAX(mailid) as 'maxid' FROM mail;";

        ResultSet resultSet = null;
        int number = 10000;

        try {
            resultSet = getStatement().executeQuery(sql);

            resultSet.next();
            number = resultSet.getInt("maxid");

            number++;
            sql = "INSERT INTO mail (mailid,userid,hash,message) values(" + number + "," + user.getId() + ",'"+ message.getHash() +"','" + message.getContent().replace("'", "\"") + "');";

            getStatement().execute(sql);

            resultSet.close();
            getStatement().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveMail(User user, Message message) {

        ResultSet resultSet = null;

        try {

            String sql = "INSERT INTO mail (mailid,userid,hash,message) values(" + message.getId() + "," + user.getId() + ",'"+ message.getHash() +"','" + message.getContent() + "');";

            getStatement().execute(sql);

            resultSet.close();
            getStatement().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean mailAlreadyExsists(String hash, User user) {

        String sql = "SELECT * FROM mail WHERE hash like '"+hash+"';";

        boolean mail = false;

        ResultSet resultSet;

        try {
            resultSet = getStatement().executeQuery(sql);

            while (resultSet.next()) {
                mail = true;
            }

            resultSet.close();
            getStatement().close();

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return mail;

    }
}
