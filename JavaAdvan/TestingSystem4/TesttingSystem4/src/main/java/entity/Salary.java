package entity;

import enumConfig.SalaryConverter;
import enumConfig.SalaryEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Salary",catalog = "TestingSystem")
public class Salary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalaryID")
    private short SalaryID;

    @Column(name = "SalaryName",nullable = false)
    @Convert(converter = SalaryConverter.class)
    private SalaryEnum SalaryName;


    public Salary() {
    }

    public short getSalaryID() {
        return SalaryID;
    }

    public void setSalaryID(short salaryID) {
        SalaryID = salaryID;
    }

    public SalaryEnum getSalaryName() {
        return SalaryName;
    }

    public void setSalaryName(SalaryEnum salaryName) {
        SalaryName = salaryName;
    }

}
