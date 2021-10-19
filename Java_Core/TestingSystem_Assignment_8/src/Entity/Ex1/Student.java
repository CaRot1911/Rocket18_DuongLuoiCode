package Entity.Ex1;

public class Student {

    static int count = 0;
    private Integer id;
    private String name;

    public Student( String name) {
        this.id = count++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    // Method Search id
    public void searchID(Integer id){
        if (id == getId()){
            System.out.println("ID: " + getId() + " - " + "Name: " + getName());
        }
    }

    // Method name
    public void DisplayName(String name){
        if(name.equalsIgnoreCase(getName())){
            System.out.println("ID: " + getId() + " - " +  "Name: " + getName());
        }
    }
    @Override
    public String toString() {
        return "Id: " + id + " - "+"Name: " + getName();
    }
}
