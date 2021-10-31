package Entity.Ex3;

import java.util.Arrays;

public class Emp <T>{
    private int id;
    private String name;
    private T[] salary;

    public Emp(int id, String name, T[] salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T[] getSalary() {
        return salary;
    }

    public void setSalary(T[] salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + '\'' + ", salary=" + Arrays.toString(salary);
    }
}
