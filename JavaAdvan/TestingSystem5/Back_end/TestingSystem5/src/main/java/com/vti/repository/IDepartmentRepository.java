package com.vti.repository;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentRepository {

    public void createDepartments(Department department);
    public List<Department> getAllDepartments();
    public Department getDepartmentByID(int DepID);
    public Department getDepartmentByName(String DepName);
    public void updateDepartments(Department department);
    public void updateDepartment(int id, String newName);
    public void deleteDepartment(int DepID);
    public boolean isDepartmentExistsByID(int DepID);
    public boolean isDepartmentExistsByName(String DepName);

}
