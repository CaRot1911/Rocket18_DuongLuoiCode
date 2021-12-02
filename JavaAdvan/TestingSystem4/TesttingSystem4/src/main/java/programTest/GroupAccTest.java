package programTest;

import entity.GroupAccount;
import repository.GroupAccRepository;

import java.util.List;

public class GroupAccTest {

    public static void main(String[] args) {
        GroupAccRepository groupAccRepository = new GroupAccRepository();

        List<GroupAccount> groupAccountList = groupAccRepository.getAllGroupAcc();

        for (GroupAccount groupAccount : groupAccountList){
            System.out.println(groupAccount.getGroup().getGroupID() + "-" + groupAccount.getAccount().getAccountID());
        }
    }
}
