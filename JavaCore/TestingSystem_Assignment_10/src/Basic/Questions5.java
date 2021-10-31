package Basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Questions5 {
    public static void deletePos() throws SQLException {

        String databaseURL = "jdbc:mysql://localhost:3306/sql_noit";
        String usename = "root";
        String password = "123456";

        /*?autoReconnect=true&useSSL=false&characterEncoding=latin1*/
        Questions1 con = new Questions1();

        /*Connected*/
        Connection connection = con.getConnection(databaseURL,usename,password);

        /* Query*/
        String query = "DELETE FROM `position` WHERE `PositionName` = ? AND `PositionID` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("ID Pos: ");
        int id = sc.nextInt();
        System.out.println("Name Pos: ");
        String namePos = sc.next();

        preparedStatement.setString(1,namePos);
        preparedStatement.setInt(2,id);

        int count = preparedStatement.executeUpdate();

        System.out.println("After Delete: " + count);

        con.disConnections(); // Disconnect
    }

    public static void main(String[] args) throws SQLException {
        deletePos();
    }
}
