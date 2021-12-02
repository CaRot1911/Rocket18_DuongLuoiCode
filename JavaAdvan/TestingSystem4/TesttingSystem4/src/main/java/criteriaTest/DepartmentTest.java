package criteriaTest;


import entity.Department;
import repositoryCriteria.DepartmentRepositoryCriteria;

import java.util.List;

public class DepartmentTest {

    public static void main(String[] args) {

        DepartmentRepositoryCriteria departmentRepositoryCriteria = new DepartmentRepositoryCriteria();


        System.out.println("==================GET DEPARTMENT=======================");
        List<Department> departmentList = departmentRepositoryCriteria.getAllDepartment(null,"6",null,null);
        for (Department elem : departmentList){
            System.out.println(elem.getDepartmentID()+"-"+elem.getDepartmentName()+"-"+elem.getDetailDepartment().getAddressID().getAddressName());
        }

        System.out.println("==================CREATE DEPARTMENT=======================");
        Department department = new Department();
        department.setDepartmentName("Tester");
        departmentRepositoryCriteria.createDepartment(department);

        System.out.println("==================COUNT DEPARTMENT=======================");
        System.out.println(departmentRepositoryCriteria.getCountDepartment("Test",null));

        System.out.println("==================GET DEPARTMENT BY ID=======================");
        Department department1 = departmentRepositoryCriteria.getDepartmentById((short) 1);
        System.out.println(department1.getDepartmentID()+"-"+department1.getDepartmentName()+"-"+department1.getDetailDepartment().getEmulationPoint());

        System.out.println("==================GET DEPARTMENT BY NAME=======================");
        Department department2 = departmentRepositoryCriteria.getDepartmentByName("Sale");
        System.out.println(department2.getDepartmentID() + "-" +department2.getDepartmentName()+"-"+department2.getDetailDepartment().getEmulationPoint());

        System.out.println("==================IS DEPARTMENT BY ID=======================");
        System.out.println(departmentRepositoryCriteria.isGetDepartmentByID((short) 1));

        System.out.println("==================IS DEPARTMENT BY NAME=======================");
        System.out.println(departmentRepositoryCriteria.isGetDepartmentByName("Test"));

        System.out.println("==================UPDATE DEPARTMENT=======================");
        departmentRepositoryCriteria.updateDepartment((short) 16,"Testing");

        System.out.println("==================DELETE DEPARTMENT=======================");
        departmentRepositoryCriteria.deleteDepartment((short) 16);

    }
}
