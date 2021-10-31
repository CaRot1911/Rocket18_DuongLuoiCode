package backend.service;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public List<User> getListUser() throws SQLException;
    public void getUser(String userID) throws SQLException;
    public boolean deleteUser(String userID) throws SQLException;
}
