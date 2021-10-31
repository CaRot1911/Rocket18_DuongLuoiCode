package Basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Questions3 {


    public static void createPos() throws SQLException {

        String databaseURL = "jdbc:mysql://localhost:3306/sql_noit";
        String usename = "root";
        String password = "123456";

        Questions1 con = new Questions1();
        Connection connection = con.getConnection(databaseURL,usename,password);

        /* Create a statement obj*/
        String query = "INSERT `position`(`PositionName`) VALUES(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        /*PosName Input*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Input posName: ");
        String posName = sc.next();


        /*Set parameter*/

        preparedStatement.setString(1,posName);

        //preparedStatement.executeQuery();
        int count = preparedStatement.executeUpdate();


        /* hading result set*/
        System.out.println("After: " + count);

        con.disConnections();

    }

    public static void main(String[] args) throws SQLException {

        createPos();
    }

}
