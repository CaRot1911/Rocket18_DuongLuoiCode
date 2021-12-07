package com.vti.controller;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/departments")
@CrossOrigin(value = "http://127.0.0.1:5500")
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    @GetMapping()
    public ResponseEntity<?> getAllDepartments(){
        List<Department> entities = iDepartmentService.getAllDepartments();

        return new ResponseEntity<List<Department>>(entities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDepartments(@RequestBody Department department){

        iDepartmentService.createDepartments(department);

        return new ResponseEntity<String>("Create Successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") int id){

        return new ResponseEntity<Department>(iDepartmentService.getDepartmentByID(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") int id,@RequestBody Department department){
        department.setDepartmentID(id);
        iDepartmentService.updateDepartment(department);

        return new ResponseEntity<String>("Update Successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") int id){
        iDepartmentService.deleteDepartment(id);

        return new ResponseEntity<String>("Delete Successfully", HttpStatus.OK);
    }

}
