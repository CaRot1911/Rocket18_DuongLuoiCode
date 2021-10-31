package Exercise_2_Polymorphism.Question_2;

import java.util.Scanner;

public abstract class Person {
    protected String name;
    protected String sex;
    protected String date;
    protected String address;

    public Person() {
    }

    public Person(String name, String sex, String date, String address) {
        this.name = name;
        this.sex = sex;
        this.date = date;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name: ");
        name = sc.next();
        System.out.println("Input sex: ");
        sex = sc.next();
        System.out.println("Input date: ");
        date = sc.next();
        System.out.println("Input address: ");
        address = sc.next();

    }

    public void showInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Sex: " + getSex());
        System.out.println("DateOfBirth: " + getDate());
        System.out.println("Address: " + getAddress());
    }
}
