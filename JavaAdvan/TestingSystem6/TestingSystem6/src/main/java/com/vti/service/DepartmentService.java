package com.vti.service;

import com.vti.entity.Department;
import com.vti.utils.Filter;
import com.vti.utils.Paging;
import com.vti.utils.Sort;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment(Filter filter, Sort sort, Paging paging,String search) {

        return departmentRepository.getAllDepartment(filter, sort, paging,search);
    }


}
