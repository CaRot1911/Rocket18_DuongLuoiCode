package Testing1;


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
