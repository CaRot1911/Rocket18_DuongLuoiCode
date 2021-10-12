package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectWithDataBase {
    private Connection connection;

    public Connection getConnection(String databaseURL,String usename,String password) throws SQLException {
        if(connection==null){
            connection = DriverManager.getConnection(databaseURL, usename, password);
        }
        return connection;
    }

    public void disConnection() throws SQLException {
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }
}
