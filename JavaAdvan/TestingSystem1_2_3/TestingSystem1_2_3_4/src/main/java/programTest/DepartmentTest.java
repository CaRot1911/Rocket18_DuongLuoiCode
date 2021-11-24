package programTest;

import entity.Department;
import repository.DepartmentRepository;

import java.util.List;

public class DepartmentTest {

    public static void main(String[] args) {

        DepartmentRepository departmentRepository =new DepartmentRepository();

        List<Department> departmentList = departmentRepository.getAllDepartment();

        for (Department elem : departmentList){
            System.out.println(elem.getDepartmentID()+"-"+elem.getDepartmentName());
        }
        Department department = departmentRepository.getDepartmentById((short) 1);
        System.out.println(department.getDepartmentID() + "-" +department.getDepartmentName());

    }
}
