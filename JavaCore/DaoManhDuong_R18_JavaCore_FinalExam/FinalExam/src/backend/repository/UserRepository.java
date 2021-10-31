package backend.repository;

import database.ConnectWithDataBase;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository  {

    @Override
    public List<User> getListUser() throws SQLException {
        List<User> userList = new ArrayList<>();
        ConnectWithDataBase connect = new ConnectWithDataBase();
        Connection con = connect.getConnection();
        String sql = "SELECT * FROM `Use`";

        Statement statement = con.createStatement();
        ResultSet resultSet  = statement.executeQuery(sql);
        while(resultSet.next()){
            User user = new User();
            user.setId(resultSet.getString(1));
            user.setFullName(resultSet.getString(2));
            user.setEmail(resultSet.getString(3));
            user.setPassword(resultSet.getString(4));
            userList.add(user);
        }
        connect.disConnect();
        return userList;
    }

    @Override
    public void getUser(String userID) throws SQLException {
        ConnectWithDataBase connect = new ConnectWithDataBase();
        Connection con = connect.getConnection();
        String sql  = "SELECT * FROM `Use` WHERE ID = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,userID);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1) +"-"+ resultSet.getString(2));
        }
    }

    @Override
    public boolean deleteUser(String userID) throws SQLException {
        ConnectWithDataBase connect = new ConnectWithDataBase();
        Connection con = connect.getConnection();
        String query = "DELETE FROM `Use` WHERE ID = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1,userID);

        int count = preparedStatement.executeUpdate();
        if (count == 0){
            return false;
        }
        connect.disConnect();
        return true;


    }
}
