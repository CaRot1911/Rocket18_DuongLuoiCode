package fontend;

import backend.repository.UserRepository;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws SQLException {

        UserRepository userRepository = new UserRepository();
        List<User> userList =  userRepository.getListUser();
        for (User elem : userList){

        }
        userRepository.getUser("1001");
    }
}
