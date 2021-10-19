package CRUD.Questions4;

import CRUD.Questions2.Department;

import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) throws SQLException {

        Department department = new Department();

        System.out.println(department.isDepartmentNameExists("Sales"));
    }
}
