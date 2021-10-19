package JDBCutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Questions2_3 {
    private static Connection connection;

    public static void connect(String dbURL,String userName,String password){
        try {
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(dbURL, userName, password);
                System.out.println("Connect!!");
            }
        } catch (SQLException e) {
            System.out.println("Cannot Connect");
            e.printStackTrace();
        }
    }

    public static void disconect() throws SQLException {
        if(connection != null && connection.isClosed()){
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException {

        String databaseURL = "jdbc:mysql://localhost:3306/sql_noit";
        String usename = "root";
        String password = "123456";

        Questions2_3.connect(databaseURL,usename,password);
        Questions2_3.disconect();

    }
}
