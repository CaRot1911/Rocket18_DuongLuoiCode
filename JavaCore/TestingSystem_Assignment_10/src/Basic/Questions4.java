package Basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Questions4 {

    public static void updatePos() throws SQLException {
        String databaseURL = "jdbc:mysql://localhost:3306/sql_noit";
        String usename = "root";
        String password = "123456";

        Questions1 con = new Questions1();
        Connection connection = con.getConnection(databaseURL,usename,password);

        /* Create a statement obj*/
        String query = "UPDATE `position` SET  `PositionName` = ? WHERE `PositionID` = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        String posName = "Dev";
        int posID = 5;

        preparedStatement.setString(1,posName);
        preparedStatement.setInt(2,posID);

        int count = preparedStatement.executeUpdate();

        System.out.println("After update: " + count);

        con.disConnections();
    }

    public static void main(String[] args) throws SQLException {

        updatePos();
    }
}
