package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Manager",catalog = "TestingSystem")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Manager extends Account implements Serializable {


    @Id
    @OneToOne()
    @JoinColumn(name = "AccountID",referencedColumnName = "AccountID")
    private Account accountID;

    @Column(name = "ManagementNumberOfYear",nullable = false)
    private short managementNumberOfYear;

    public Manager() {
    }

    public short getManagementNumberOfYear() {
        return managementNumberOfYear;
    }

    public void setManagementNumberOfYear(short managementNumberOfYear) {
        managementNumberOfYear = managementNumberOfYear;
    }
}
