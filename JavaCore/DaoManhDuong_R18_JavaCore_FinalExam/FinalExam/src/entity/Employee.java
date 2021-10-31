package entity;

public class Employee extends User{
    private String proSkill;


    public Employee(String id, String fullName, String email, String password,String proSkill) {
        super(id, fullName, email, password);
        this.proSkill = proSkill;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString()+"-" + "ProSkill: "+getProSkill();
    }
}
