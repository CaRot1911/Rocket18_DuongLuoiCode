package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Manager",catalog = "TestingSystem")
public class Manager implements Serializable {


    @Id
    @OneToOne()
    @JoinColumn(name = "AccountID",referencedColumnName = "AccountID")
    private Account accountID;

    @Column(name = "ManagementNumberOfYear",nullable = false)
    private short managementNumberOfYear;

    public Manager() {
    }

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        accountID = accountID;
    }

    public short getManagementNumberOfYear() {
        return managementNumberOfYear;
    }

    public void setManagementNumberOfYear(short managementNumberOfYear) {
        managementNumberOfYear = managementNumberOfYear;
    }
}
