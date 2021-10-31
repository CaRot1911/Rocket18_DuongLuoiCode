
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Exercise_5 {

    public int accID;
    public Scanner sc = new Scanner(System.in);

    Exercise_5(){

    }

    void Question_1(){
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
    }

    void Question_2(){
        float a = sc.nextFloat();
        float b = sc.nextFloat();
    }

    void Question_3(){
        System.out.println("First Name: ");
        String strFirstName = sc.nextLine();
        System.out.println("Last name: ");
        String stcLastname = sc.nextLine();
    }

    void Question_4(){
        Date date = new Date();
        System.out.println("Date: ");
    }

    void Question_5(){
        Account acc = new Account();
        System.out.println("Acc ID: ");
        acc.AccountID = sc.nextInt();
        System.out.println("Email : ");
        acc.Email = sc.nextLine();
        System.out.println("User Name: ");
        acc.userName =sc.nextLine();
        System.out.println("DepartmentID: ");
        acc.departmentID.DepartmentID = sc.nextInt();
        System.out.println("PositionID: ");
        acc.positionID.positionID = sc.nextInt();
        switch (acc.positionID.positionID){
            case 1:
                acc.positionID.positionName = "Dev";
                break;
            case 2:
                acc.positionID.positionName = "Test";
                break;
            case 3:
                acc.positionID.positionName = "ScrumMaster";
                break;
            case 4:
                acc.positionID.positionName = "PM";
                break;
            default:
                break;


        }
        System.out.println("Create Date: ");
        acc.createDate = sc.nextLine();
    }

    void Question_6(){
        Department dep = new Department();
        System.out.println("Dep ID: ");
        dep.DepartmentID = sc.nextInt();
        System.out.println("Dep Name: ");
        dep.departmentName = sc.nextLine();
    }

    void Question_7(){
        int n = sc.nextInt();
        if(n%2 == 0){
            System.out.println("So Chan");
        }else{
            System.out.println("So le");
        }
    }

    void Question_8(){
        int n = 0;
        do {
            System.out.println("mời bạn nhập vào chức năng muốn sử dụng: ");
            n = sc.nextInt();
            switch (n) {

                case 1:
                    System.out.println("Nhập thông tin");
                    Account acc = new Account();
                    Department dep = new Department();
                    System.out.println("Acc ID: ");
                    acc.AccountID = sc.nextInt();
                    System.out.println("Email : ");
                    acc.Email = sc.next();
                    System.out.println("User Name: ");
                    acc.userName = sc.next();
                    System.out.println("DepartmentID: ");
                    acc.departmentID.DepartmentID = sc.nextInt();
                    System.out.println("PositionID: ");
                    acc.positionID.positionID = sc.nextInt();
                    System.out.println("Create Date: ");
                    acc.createDate = sc.next();

                    break;
                case 2:
                    System.out.println("Nhập thông tin");
                    Department dep1 = new Department();
                    System.out.println("Dep ID: ");
                    dep1.DepartmentID = sc.nextInt();
                    System.out.println("Dep Name: ");
                    dep1.departmentName = sc.next();
                    break;
            }
        }while (n!=0);
    }

    void Question_9() {
        String strAcc;
        String grName;
        Department dep1 = new Department(1, "Marketing");
        Department dep2 = new Department(2, "Sales");
        Department dep3 = new Department(3, "Room");

        Position pos1 = new Position(1, "Dev");
        Position pos2 = new Position(2, "Test");
        Position pos3 = new Position(3, "PM");

        Account acc = new Account(1, "abc@gamil.com", "abc", "abc", dep1, pos1, "2021/09/12");
        Account acc1 = new Account(2, "xyz@gamil.com", "xyz", "xyz", dep2, pos2, "2021/09/12");
        Account acc2 = new Account(3, "asd@gamil.com", "asd", "asd", dep3, pos3, "2021/09/12");

        // List acc
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(acc);
        accounts.add(acc1);
        accounts.add(acc2);

        Group gr = new Group(1, "Class 1", acc, "2020/09/12");
        Group gr1 = new Group(2, "Class 2", acc1, "2020/09/12");
        Group gr2 = new Group(3, "Class 3", acc, "2020/09/12");

        // list group
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(gr);
        groups.add(gr1);
        groups.add(gr2);

        // Show user
        System.out.println("Use Name: ");
        for (Account elem : accounts) {
            System.out.println(elem.userName);
        }


        // Input userName
        System.out.println("input User Name: ");
        strAcc = sc.next();

        // Show group
        System.out.println("Group Name: ");
        for (Group elem : groups) {
            System.out.println(elem.groupName);
        }

        // Input group name
        System.out.println("Input groupName: ");
        {
            grName = sc.next();
        }


        for (Account elem : accounts) {
            if (strAcc.equals(elem.userName) == true) {
                accID = elem.AccountID;
            }
        }
        System.out.println(accID);
        for (Group elem : groups){
            if(grName.equals(elem.groupName) == true){
                elem.groupID = elem.groupID;
                elem.AccountID.AccountID = accID;
                elem.groupName = elem.groupName;
                elem.createDate = elem.createDate;
                System.out.println(elem);
            }
        }
    }

    // Ques 10 and 11

    public static void main(String[] args) {
        Exercise_5 Ex5 = new Exercise_5();

        Ex5.Question_8();

    }
}