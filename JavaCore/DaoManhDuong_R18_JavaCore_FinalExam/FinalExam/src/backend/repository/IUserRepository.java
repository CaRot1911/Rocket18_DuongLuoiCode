package backend.repository;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public List<User> getListUser() throws SQLException;
    public void getUser(String userID) throws SQLException;
    public boolean deleteUser(String userID) throws SQLException;
}
