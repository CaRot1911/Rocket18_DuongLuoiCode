package JDBCutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataDemo {

    public static void isConnectedForTesting() {
        String databaseURL = "jdbc:mysql://localhost:3306/sql_noit";
        String usename = "root";
        String password = "123456";

        try {
            Connection collections = DriverManager.getConnection(databaseURL,usename,password);
            System.out.println("Connect success!");
        } catch (SQLException e) {
            System.out.println("Not Connected");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //isConnectedForTesting();
        String databaseURL = "jdbc:mysql://localhost:3306/sql_noit";
        String usename = "root";
        String password = "123456";
    }
}
