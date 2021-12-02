package programTest;

import entity.Group;
import repository.GroupRepository;

import java.util.List;

public class GroupTest {

    public static void main(String[] args) {

        GroupRepository groupRepository = new GroupRepository();

        List<Group> groupList = groupRepository.getAllGroup();

        for (Group group : groupList){
            System.out.println(group.getGroupID() + "-" + group.getGroupName() + "-" +group.getCreateDate());
        }
    }
}
