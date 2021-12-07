package com.vti.service;

import com.vti.entity.Department;
import com.vti.utils.Filter;
import com.vti.utils.Paging;
import com.vti.utils.Sort;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartment(Filter filter, Sort sort, Paging paging,String search);


}
