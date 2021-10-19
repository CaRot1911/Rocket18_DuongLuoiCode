package CRUD.Questions1;

import java.sql.SQLException;
import java.util.ArrayList;


public class Demo {

    public static void main(String[] args) throws SQLException {
        Department department = new Department();
        ArrayList<Department> departmentArrayList = department.getDepartments();

        for (Department elem : departmentArrayList){
            System.out.println(elem.getId() +"-"+ elem.getDepName());
        }

    }
}
