package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Employee",catalog = "TestingSystem")
public class Employee implements Serializable {


    @Id
    @OneToOne()
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    private Account accountID;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear;

    public Employee() {
    }

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        accountID = accountID;
    }

    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        workingNumberOfYear = workingNumberOfYear;
    }
}
