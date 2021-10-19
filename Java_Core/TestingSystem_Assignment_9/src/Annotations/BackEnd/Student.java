package Annotations.BackEnd;

public class Student {

    public  static int count = 0;

    private int id;
    private String name;

    public Student(String name) {
        this.id = ++count;
        this.name = name;
    }

    @Deprecated
     public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID(){
        return "MSV: " + id;
    }
}
