package BackEnd.Ex3;

import Entity.Ex3.Emp;
import Entity.Ex3.Phone;
import Entity.Ex3.Staff;
import Entity.Ex3.Students;

public class Generic {

    private <T> void print(T a){
        System.out.println(a);
    }
    private <T> void printArray(T[] a){
        for(T x : a){
            System.out.println(x);
        }
    }

    public void Questions1_2_3(){
        Students<Integer> students = new Students<>(1,"Duong");
        Students<Float> students1 = new Students<>(1f,"Duong");
        Students<Double> students2 = new Students<>(1d,"Duong");

        print(students.toString());
        print(students1.toString());
        print(students2.toString());

        print(1);
        print(1f);
        print(1d);
    }

    public void Questions4(){
        Integer[] a = {1,2,3};
        Float[] b = {1f,2f,3f};
        Double[] c = {1d,2d,3d};

        printArray(a);
        printArray(b);
        printArray(c);

    }

    public void Questions5(){
       Integer[] srEmp = {1000,2000,3000};
       Emp<Integer> emp = new Emp<>(1,"Duong",srEmp);
        print(emp.toString());
       System.out.println("Luong thang cuoi cung: " + srEmp[srEmp.length -1]);

        Float[] srEmp1 = {1000f,2000f,3000f};
        Emp<Float> emp1 = new Emp<>(1,"Duong",srEmp1);
        print(emp1.toString());
        System.out.println("Luong thang cuoi cung: " + srEmp1[srEmp1.length -1]);

        Double[] srEmp2 = {1000d,2000d,3000d};
        Emp<Double> emp2 = new Emp<>(1,"Duong",srEmp2);
        print(emp2.toString());
        System.out.println("Luong thang cuoi cung: " + srEmp2[srEmp2.length -1]);
    }

    public void Questions6(){
        Students<Integer> std = new Students<>(1000,"Manh Duong");
        print(std.getId());
        print(std.getName());
    }
    public void Questions7(){

        System.out.println("Key = Email: ");
        Phone<String, String> phone = new Phone<>("abacs@gmail.com","02190321");
        print(phone.getPhoneNumber());
        print(phone.getKey());
        System.out.println("=======================================");
        System.out.println("Key = number: ");
        Phone<Integer, String> phone1 = new Phone<>(1,"02190321");
        print(phone1.getPhoneNumber());
        print(phone1.getKey());
        System.out.println("=======================================");
        System.out.println("Key = name");
        Phone<String, String> phone2 = new Phone<>("Nguyen Van A","02190321");
        print(phone2.getPhoneNumber());
        print(phone2.getKey());
    }

    public void Questions8(){
        System.out.println("ID INT: ");
        Staff<Integer> staff = new Staff<>(1001,"Nguyen Van A");
        System.out.println(staff.getId());
        System.out.println(staff.getName());
        System.out.println("=======================================");
        System.out.println("ID LONG: ");
        Staff<Long> staff1 = new Staff<>(1002l,"Nguyen Van B");
        System.out.println(staff1.getId());
        System.out.println(staff1.getName());

    }
}
