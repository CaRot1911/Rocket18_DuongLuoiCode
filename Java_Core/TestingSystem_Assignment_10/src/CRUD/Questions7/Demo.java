package CRUD.Questions7;

import CRUD.Questions2.Department;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws Exception {
        Department department = new Department();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID Delete: ");
        int id = sc.nextInt();

        department.deleteDepartment(id);
    }
}
