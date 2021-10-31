package Exercise_5.Ques2;

public class Department {
    Integer id;
    String name;

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: " + id + " : " + "Name: "+ name;
    }
}
