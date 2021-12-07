package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository iDepartmentRepository;
    @Override
    public void createDepartments(Department department) {
        iDepartmentRepository.createDepartments(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return iDepartmentRepository.getAllDepartments();
    }

    @Override
    public Department getDepartmentByID(int DepID) {
        return iDepartmentRepository.getDepartmentByID(DepID);
    }

    @Override
    public Department getDepartmentByName(String DepName) {
        return iDepartmentRepository.getDepartmentByName(DepName);
    }

    @Override
    public void updateDepartments(int id, String newDepName) {
        iDepartmentRepository.updateDepartment(id,newDepName);
    }


    @Override
    public void updateDepartment(Department department) {
        iDepartmentRepository.updateDepartments(department);
    }

    @Override
    public void deleteDepartment(int DepID) {
        iDepartmentRepository.deleteDepartment(DepID);
    }

    @Override
    public boolean isDepartmentExistsByID(int DepID) {
        return iDepartmentRepository.isDepartmentExistsByID(DepID);
    }

    @Override
    public boolean isDepartmentExistsByName(String DepName) {
        return iDepartmentRepository.isDepartmentExistsByName(DepName);
    }
}
