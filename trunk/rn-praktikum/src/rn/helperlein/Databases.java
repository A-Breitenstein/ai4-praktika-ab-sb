package rn.helperlein;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * User: Alex
 * Date: 30.03.13
 * Time: 12:06
 */
public class Databases {

    /**
     *
     * @param databaseName
     * @return
     */
    public static Connection initializeSQLiteConnection(String databaseName) {

        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            //Alex
            String url = "jdbc:sqlite:D:/Alex/HAW/AI-4/RN/rn-praktikum/"+ databaseName +".db";
//            String url = "jdbc:sqlite:"+ databaseName +".db";


            //Sven
//            String url;


            //HAW
//            String url;

            connection = DriverManager.getConnection(url);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return connection;
    }
}
