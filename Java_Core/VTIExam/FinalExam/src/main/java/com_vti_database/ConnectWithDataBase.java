package com_vti_database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectWithDataBase {

    private Connection connection;

    public Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("E:\\VTI\\FinalExam\\src\\data.properties"));
        String URL = properties.getProperty("databaseURL");
        String user = properties.getProperty("user");
        String pass = properties.getProperty("password");
        if (connection==null){
            connection = DriverManager.getConnection(URL,user,pass);
        }
        return connection;
    }

    public void disConnect() throws SQLException {
        if(connection != null || !connection.isClosed()){
            connection.close();
        }
    }
}
