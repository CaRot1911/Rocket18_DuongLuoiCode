package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Employee",catalog = "TestingSystem")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Employee extends Account implements Serializable {



    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear;

    public Employee() {
    }

    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        workingNumberOfYear = workingNumberOfYear;
    }
}
