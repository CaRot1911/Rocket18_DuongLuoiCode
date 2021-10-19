package Emty;

public class Student {

    private  Integer id;
    private String name;
    static String college = "Đại học bách khoa";
    private static int moneyGroup = 0;
    public static int count = 0;
    public static final int maxStudent = 7;


    public Student() {
    }
    public Student(String name) throws Exception {
        this.id = ++count;
        if(count > maxStudent){
            throw new Exception("Khong duoc qua 7 sinh vien");
        }
        this.name = name;
        moneyGroup += 100000;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    public static int getMoneyGroup() {
        return moneyGroup;
    }

    public static void Lay(int money) {
        Student.moneyGroup -= money;
    }

    public  void countMoney() {
        moneyGroup += 50000;
    }
    @Override
    public String toString() {
        return "ID: " + id + "-" + "Name: " + name + "-" + "College: "+college;
    }
}
