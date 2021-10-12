package entity;

import java.sql.Date;

public class Group {

    private static int count=0; // Auto GroupID

    private int groupID;
    private String groupName;
    private int createID;  // Sửa thành acc
    Date createDate;

    public Group(){

    }
    public Group(int groupID, String groupName, int createID, Date createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.createID = createID;
        this.createDate = createDate;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getCreateID() {
        return createID;
    }

    public void setCreateID(int createID) {
        this.createID = createID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {

        return "GroupID: "+getGroupID() + "-" + "GroupName: "+getGroupName()+"-"+"CreateID: " + getCreateID()+"-"+"CreateDate: "+getCreateDate();
    }

}
