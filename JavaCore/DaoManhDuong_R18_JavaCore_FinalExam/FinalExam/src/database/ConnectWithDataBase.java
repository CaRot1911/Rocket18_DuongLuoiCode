package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectWithDataBase {
    private Connection connection;
    public Connection getConnection() throws SQLException {
         String databaseURL = "jdbc:mysql://localhost:3306/finalexam";
         String usename = "root";
         String password = "123456";
         if(connection == null || connection.isClosed()){
             connection = DriverManager.getConnection(databaseURL,usename,password);
         }
         return connection;

    }
    public void disConnect() throws SQLException {
        if(connection != null || !connection.isClosed()){
            connection.close();
        }
    }
}
