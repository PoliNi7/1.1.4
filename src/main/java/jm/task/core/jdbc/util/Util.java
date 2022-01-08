package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getMySQLConnection() {
        String hostName = "localhost";
        String dbName = "new_schema";
        String userName = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            System.out.println("Проблемы с соединением с БД");
            e.printStackTrace();
        }
        return connection;
    }
}
