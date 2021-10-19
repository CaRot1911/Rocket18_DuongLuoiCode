package Basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Questions2 {

    public static void outPositions() throws SQLException, ClassNotFoundException {
        String databaseURL = "jdbc:mysql://localhost:3306/sql_noit";
        String usename = "root";
        String password = "123456";

        /*?autoReconnect=true&useSSL=false&characterEncoding=latin1*/
        Questions1 con = new Questions1();

        /* Connected */
        Connection connection = con.getConnection(databaseURL, usename, password);

        /* Create a statement object */
         Statement statement = connection.createStatement();

        /* Query */
        String query = "SELECT * FROM position";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " "  +resultSet.getString(2) );
        }

        con.disConnections();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        outPositions();
    }
}
