import Basic.Questions1;

import java.sql.Connection;
import java.sql.SQLException;

public class Program1 {



    public static void main(String[] args) throws SQLException {

        String dbURL = "jdbc:mysql://localhost:3306/sql_noit";
        String name = "root";
        String password = "123456";

        Questions1 connect = new Questions1();

        Connection con = null;
        try{
            con = connect.getConnection(dbURL,name,password);
            System.out.println("Connect success!");
        } catch (SQLException throwables) {
            System.out.println("Can't connections DataBase");
            throwables.printStackTrace();
        }
        connect.disConnections();


    }
}
