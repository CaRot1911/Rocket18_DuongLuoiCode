package Table_5_GroupAccount;

import Table_3_Account.Account;
import Table_4_Group.Group;

public class GroupAccount {
    Group groupID;
    Account accountID;
    String joinDate;

    GroupAccount(){

    }

    public GroupAccount(Group groupID, Account accountID, String joinDate)
    {
        this.accountID = accountID;
        this.groupID =  groupID;
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "GroupAccount{" +
                "groupID=" + groupID.groupID +
                ", accountID=" + accountID.AccountID +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }
}
