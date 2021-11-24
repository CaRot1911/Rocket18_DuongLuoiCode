package entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Account",catalog = "TestingSystem")
public class Account implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private short AccountID;

    @Column(name = "Email",nullable = false,length = 50,unique = true,updatable = false)
    private String Email;

    @Column(name = "Username",length = 50,nullable = false,unique = true,updatable = false)
    private String Username;

    @Column(name = "FirstName",length = 50,nullable = false)
    private String  FirstName;

    @Column(name = "LastName",length = 50,nullable = false)
    private String LastName;


    @Formula(" concat(FirstName,' ',LastName) ")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "DepartmentID",referencedColumnName = "DepartmentID",nullable = true,columnDefinition = "waiting")
    private Department departmentID;

    @ManyToOne
    @JoinColumn(name = "PositionID",referencedColumnName = "PositionID",nullable = false,columnDefinition = "Dev")
    private Position positionID;

    @ManyToOne
    @JoinColumn(name = "SalaryID",referencedColumnName = "SalaryID",nullable = false,columnDefinition = "600")
    private Salary salaryID;

    @Column(name = "CreateDate",columnDefinition = "DEFAULT NOW()",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreateDate;


    public Account() {

    }


    public short getAccountID() {
        return AccountID;
    }

    public void setAccountID(short accountID) {
        AccountID = accountID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Department departmentID) {
        departmentID = departmentID;
    }

    public Position getPositionID() {
        return positionID;
    }

    public void setPositionID(Position positionID) {
        positionID = positionID;
    }

    public Salary getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(Salary salaryID) {
        salaryID = salaryID;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
