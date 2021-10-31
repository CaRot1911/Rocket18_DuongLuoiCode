package entity;

import java.sql.Date;

public class Account {

    private static int id =0;  //AccID auto

    private  int accountID;
    private String email;
    private String userName;
    private String fullName;
    private int departmentID;
    private int positionID;
    private Date createDate;
    private String gender;

    public Account(){

    }
    public Account(int accountID,String email, String userName, String fullName, int departmentID, int positionID, Date createDate, String gender) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.departmentID = departmentID;
        this.positionID = positionID;
        this.createDate = createDate;
        this.gender = gender;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "accountID= "+getAccountID()+"-"+"email= "+getEmail()+"-"+"userName= "+getUserName()+"-"+"fullName= "+getFullName()+'-'+"departmentID= " +getDepartmentID()+"-"+"positionID= "+getPositionID()+"-"+"createDate= " +getCreateDate()+ "-" + "gender=" +getGender() ;

    }
}
