package Call_Strore;

import CRUD.Questions2.Department;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws Exception {
        Department department = new Department();
        Scanner sc = new Scanner(System.in);

        System.out.println("Input ID Dep: ");
        int idDep = sc.nextInt();

        department.deleteDepartment(idDep);
    }
}
