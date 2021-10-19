package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectData {

    private Connection connection;
    public Connection getConnection(String databaseURL,String user,String password) throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(databaseURL,user,password);
        }
        return connection;
    }

    public void disConnections() throws SQLException {
        if(connection != null && connection.isClosed()){
            connection.close();
        }
    }
}
