public class Group {
    public int groupID;
    String groupName;
    Account AccountID;
    String createDate;

    Group(){

    }
    public Group(int groupID, String groupName, Account AccountID, String createDate){
        this.groupID = groupID;
        this.groupName = groupName;
        this.AccountID = AccountID;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", AccountID=" + AccountID.AccountID +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
