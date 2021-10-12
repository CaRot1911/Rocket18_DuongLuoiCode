package fontend;

import entity.Group;

import java.sql.SQLException;
import java.util.ArrayList;

public class TestGroup {

    public static void main(String[] args) throws SQLException {

        GroupService groupService = new GroupService();
        ArrayList<Group> list = new ArrayList<>(groupService.getLstGroup());
        for(Group elem : list){
            System.out.println(elem.toString());
        }
    }
}
