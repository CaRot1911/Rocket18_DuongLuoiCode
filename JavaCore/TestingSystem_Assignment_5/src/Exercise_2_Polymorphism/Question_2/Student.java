package Exercise_2_Polymorphism.Question_2;

import java.util.Scanner;

public class Student extends Person{

    private Integer id;
    private Double avgScore;
    private String email;

    public Student() {
    }

    public Student(String name, String sex, String date, String address, Integer id, Double avgScore, String email) {
        super(name, sex, date, address);
        this.id = id;
        this.avgScore = avgScore;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID: ");
        id = sc.nextInt();
        System.out.println("Input Email: ");
        email = sc.next();
        System.out.println("Input Avg Score: ");
        avgScore = sc.nextDouble();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("ID: " + getId());
        System.out.println("Email: " + getEmail());
        System.out.println("Avg Score: " + getAvgScore());
    }

    public boolean hocBong(){
        if(getAvgScore() > 8d){
            showInfo();
            return true;
        }
        return false;
    }
}
