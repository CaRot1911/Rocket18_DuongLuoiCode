package programTest;

import entity.Department;
import entity.DetailDepartment;
import repository.DepartmentRepository;

import java.util.List;

public class DepartmentTest {

    public static void main(String[] args) {
        DepartmentRepository departmentRepository =new DepartmentRepository();


        System.out.println("==================CREATE DEPARTMENT=======================");

        Department department3 = new Department();
        department3.setDepartmentName("Tester");

        departmentRepository.createDepartment(department3);

        System.out.println("==================GET DEPARTMENT=======================");

        String s1 = null;
        String s2 = "6";
        String s3 = null;
        String s4 = null;

        List<Department> departmentList = departmentRepository.getAllDepartment(s1,s2,s3,s4);

        for (Department elem : departmentList){
            System.out.println(elem.getDepartmentID()+"-"+elem.getDepartmentName()+"-"+elem.getDetailDepartment().getAddressID().getAddressName());

        }

        System.out.println("==================COUNT DEPARTMENT=======================");

        System.out.println(departmentRepository.getCountDepartment(null,"6"));


        System.out.println("==================GET DEPARTMENT BY ID=======================");
        Department department1 = departmentRepository.getDepartmentById((short) 1);
        System.out.println(department1.getDepartmentID() + "-" +department1.getDepartmentName()+"-"+department1.getDetailDepartment().getAddressID().getAddressName());

        System.out.println("==================GET DEPARTMENT BY NAME=======================");
        Department department2 = departmentRepository.getDepartmentByName("Sale");
        System.out.println(department2.getDepartmentID() + "-" +department2.getDepartmentName()+"-"+department2.getDetailDepartment().getAddressID().getAddressName());

        System.out.println("==================IS DEPARTMENT BY ID=======================");
        System.out.println(departmentRepository.isDepartmentById((short) 1));

        System.out.println("==================IS DEPARTMENT BY NAME=======================");
        System.out.println(departmentRepository.isDepartmentByName("Sale"));

        System.out.println("==================UPDATE DEPARTMENT=======================");
        departmentRepository.updateDepartment((short) 11,"Testing");

        System.out.println("==================DELETE DEPARTMENT=======================");
        departmentRepository.deleteDepartment((short) 11);
    }
}
