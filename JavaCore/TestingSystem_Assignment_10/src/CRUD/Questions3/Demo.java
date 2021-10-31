package CRUD.Questions3;

import CRUD.Questions2.Department;

import java.sql.SQLException;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input Department ID: ");
        int depId = sc.nextInt();

        Department department = new Department();

        department.getDepartmentsByID(depId);
    }
}
