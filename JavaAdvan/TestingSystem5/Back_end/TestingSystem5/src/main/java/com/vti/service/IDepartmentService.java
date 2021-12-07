package com.vti.service;


import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {

    public void createDepartments(Department department);
    public List<Department> getAllDepartments();
    public Department getDepartmentByID(int DepID);
    public Department getDepartmentByName(String DepName);
    public void updateDepartments(int id,String newDepName);
    public void updateDepartment(Department department);
    public void deleteDepartment(int DepID);
    public boolean isDepartmentExistsByID(int DepID);
    public boolean isDepartmentExistsByName(String DepName);
}
