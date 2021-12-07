package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Department",catalog = "TestingSystem6")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID")
    private short departmentID;

    @Column(name = "TotalMember")
    private short totalMember;

    @Column(name = "DepartmentName",nullable = false,unique = true)
    private String departmentName;

    public Department() {
    }

    public Department(short totalMember, String departmentName) {
        this.totalMember = totalMember;
        this.departmentName = departmentName;
    }

    public short getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(short departmentID) {
        this.departmentID = departmentID;
    }

    public short getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(short totalMember) {
        this.totalMember = totalMember;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
