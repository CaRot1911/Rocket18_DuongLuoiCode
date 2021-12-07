package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "Department",catalog = "testingsystem5")
public class Department implements Serializable {

    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int departmentID;

    @Column(name= "DepartmentName",length = 30,nullable = false,updatable = false)
    private String departmentName;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String name) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentID=" + departmentID + ", departmentName='" + departmentName +  '}';
    }
}
