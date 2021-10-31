package backend.datalayer;

import database.ConnectWithDataBase;
import entity.Account;


import java.sql.*;

import java.util.ArrayList;


public class AccountRepository implements IAccountRepository {
    public ArrayList<Account> getListAccounts() throws SQLException {

        ArrayList<Account> arrayList = new ArrayList<>();

        String dbURL= "jdbc:mysql://localhost:3306/sql_noit"; // Sửa lại
        String username  = "root";
        String password = "123456";

        ConnectWithDataBase con = new ConnectWithDataBase();

        Connection connection = con.getConnection(dbURL,username,password);

        /* Create statement obj*/
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM account";

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            Account account = new Account();
            account.setAccountID(resultSet.getInt("AccountID"));
            account.setEmail(resultSet.getString("Email"));
            account.setUserName(resultSet.getString("Username"));
            account.setFullName(resultSet.getString("Fullname"));
            account.setDepartmentID(resultSet.getInt("DepartmentID"));
            account.setPositionID(resultSet.getInt("PositionID"));
            account.setCreateDate(resultSet.getDate("CreateDate"));
            account.setGender(resultSet.getString("gender"));

            arrayList.add(account);
        }
        con.disConnection();
        return arrayList;
    }




      @Override
   public void createAccount(Account account) throws SQLException {
        String dbURL= "jdbc:mysql://localhost:3306/sql_noit";
        String username  = "root";
        String password = "123456";

       /*
            Connect for database
         */
       ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection(dbURL,username,password);

       /*
           Create statement object
        */
       String query = "INSERT INTO account VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1,account.getAccountID());
       preparedStatement.setString(2,account.getUserName());
       preparedStatement.setString(3,account.getEmail());
       preparedStatement.setString(4,account.getFullName());
        preparedStatement.setInt(5,account.getDepartmentID());
        preparedStatement.setInt(6,account.getPositionID());
        preparedStatement.setDate(7,account.getCreateDate());
        preparedStatement.setString(8,account.getGender());

        int countAfter = preparedStatement.executeUpdate();
        System.out.println("Account update: "+ countAfter);
        con.disConnection();
   }

    @Override
    public void getAccountByID(int id) throws SQLException {
        String dbURL= "jdbc:mysql://localhost:3306/sql_noit";
        String username  = "root";
        String password = "123456";

        /*
            Connect for database
         */
        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection(dbURL,username,password);


        String query = "SELECT * FROM account WHERE AccountID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+"-"+resultSet.getString(4));
        }

        con.disConnection();
    }

    @Override
    public boolean isAccountExists(String username) throws SQLException {
        String dbURL= "jdbc:mysql://localhost:3306/sql_noit";
        String user  = "root";
        String password = "123456";

        /*
            Connect for database
         */
        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection(dbURL,user,password);


        String query = "SELECT * FROM account WHERE Username = ?";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1,username);
         ResultSet resultSet = preparedStatement.executeQuery();
         if(resultSet.next()){
             return true;
         }
        con.disConnection();
         return false;
    }

    @Override
    public boolean isAccountExists(int id) throws SQLException {
        String dbURL= "jdbc:mysql://localhost:3306/sql_noit";
        String username  = "root";
        String password = "123456";

        /*
            Connect for database
         */
        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection(dbURL,username,password);


        String query = "SELECT * FROM account WHERE AccountId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet  = preparedStatement.executeQuery();
        if(resultSet.next()){
            return true;
        }
        con.disConnection();
        return false;
    }

    @Override
    public void updateAccountByID(int id,Account account) throws Exception {
        String dbURL= "jdbc:mysql://localhost:3306/sql_noit";
        String username  = "root";
        String password = "123456";

        /*
            Connect for database
         */
        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection(dbURL,username,password);
        /*
        Query
         */

        /*
            Người dùng được sửa một trong ba trường Email,DepartmentID,AccountID
         */
        String queryUpdateEmail = "UPDATE Account SET Email = ? WHERE AccountID = ?";
        String queryUpdateDepID = "UPDATE Account SET DepartmentID = ?  WHERE AccountID = ?";
        String queryUpdatePosID = "UPDATE Account SET PositionID = ? WHERE AccountID = ?";
        String queryUpdateFull = "UPDATE Account SET Email = ?, DepartmentID = ? ,PositionID = ? WHERE AccountID = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(queryUpdateFull);
        preparedStatement.setString(1,account.getEmail());
        preparedStatement.setInt(2,account.getDepartmentID());
        preparedStatement.setInt(3,account.getPositionID());
        preparedStatement.setInt(4,id);

        int count = preparedStatement.executeUpdate();
        System.out.println("After Update: " + count);
        con.disConnection();
    }


    @Override
    public void deleteAccount(int id) throws SQLException {
        String dbURL= "jdbc:mysql://localhost:3306/sql_noit";
        String username  = "root";
        String password = "123456";

        /*
            Connect for database
         */
        ConnectWithDataBase con = new ConnectWithDataBase();
        Connection connection = con.getConnection(dbURL,username,password);

        String query = "DELETE FROM account WHERE AccountID = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        int count = statement.executeUpdate();
        if(count > 0 ){
            System.out.println("Deleted successfully: " + count);
        }else {
            System.out.println("There are no records yet!");
        }
        con.disConnection();
    }

}
