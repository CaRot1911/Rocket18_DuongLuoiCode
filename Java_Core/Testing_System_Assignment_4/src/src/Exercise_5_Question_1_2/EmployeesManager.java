package src.Exercise_5_Question_1_2;

import java.util.Scanner;

public class EmployeesManager {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Staff staff = new Staff("Manh Duong", 12L,"Male","Ha Noi","Dev");
        Staff staff1 = new Staff("Van Huy", 9L,"Male","Ha Noi","Sales");
        Staff staff2 = new Staff("Hong Van", 12L,"Male","Ha Noi","PM");
        Management management = new Management();

        management.addStaff(staff);
        management.addStaff(staff1);
        management.addStaff(staff2);

        //management.Display();

        //management.Search();

        //management.DeleteName();
        System.out.println(management.getStaff().get(0) instanceof Staff);
    }
}
