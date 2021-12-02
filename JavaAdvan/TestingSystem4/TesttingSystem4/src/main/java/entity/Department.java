package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Department", catalog = "TestingSystem")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable,Comparable<Department> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID",nullable = false)
    private short departmentID;


    @Column(name = "DepartmentName",length = 30,nullable = false,unique = true)
    private String departmentName;

    @OneToOne(mappedBy = "departmentID")
    private DetailDepartment detailDepartment;

    public DetailDepartment getDetailDepartment() {
        return detailDepartment;
    }

    public void setDetailDepartment(DetailDepartment detailDepartment) {
        this.detailDepartment = detailDepartment;
    }


    public Department() {
    }

    public short getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(short departmentID) {
        departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public int compareTo(Department department) {
        return getDepartmentName().compareTo(department.getDepartmentName());
    }
}
