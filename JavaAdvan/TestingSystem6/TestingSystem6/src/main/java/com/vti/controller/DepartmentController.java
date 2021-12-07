package com.vti.controller;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.utils.Filter;
import com.vti.utils.Paging;
import com.vti.utils.Sort;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "departments")
@CrossOrigin(origins = "")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping(value = "allDepartments")
    public ResponseEntity<?> getAllDepartments(Filter filter, Sort sort, Paging paging,String search){
        if (paging == null){
            paging = new Paging(1,10);
        }
        if(sort == null || sort.getNameSort() == null || sort.getTypeSort() == null){
            sort = new Sort("departmentName","ASC");
        }

        List<Department> lst = departmentService.getAllDepartment(filter, sort, paging,search);

        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for (Department elem : lst){
            DepartmentDTO departmentDTO = new DepartmentDTO(elem.getDepartmentName(),elem.getTotalMember());
            departmentDTOList.add(departmentDTO);
        }

        return new ResponseEntity<List<DepartmentDTO>>(departmentDTOList, HttpStatus.OK);
    }

}
