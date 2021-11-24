package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Department", catalog = "TestingSystem")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID",nullable = false)
    private short DepartmentID;


    @Column(name = "DepartmentName",length = 30,nullable = false,unique = true)
    private String DepartmentName;

    public Department() {
    }

    public short getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(short departmentID) {
        DepartmentID = departmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

}
