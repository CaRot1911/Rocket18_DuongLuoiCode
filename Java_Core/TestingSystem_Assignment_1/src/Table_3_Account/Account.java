package Table_3_Account;


import Table_1_Department.Department;
import Table_2_Position.Position;

public class Account {
    public int AccountID;
    String Email;
    String userName;
    String fullName;
    Department departmentID;
    Position positionID;
    String createDate;

    public Account(){

    }
    public Account(int AccountID, String Email, String userName, String fullName, Department departmentID, Position positionID, String createDate){
        this.AccountID = AccountID;
        this.Email = Email;
        this.userName = userName;
        this.fullName = fullName;
        this.departmentID = departmentID;
        this.positionID = positionID;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountID=" + AccountID +
                ", Email='" + Email + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", departmentID=" + departmentID.departmentID +
                ", positionID=" + positionID.positionID +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
