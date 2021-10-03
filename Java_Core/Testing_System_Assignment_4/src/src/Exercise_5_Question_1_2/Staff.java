package src.Exercise_5_Question_1_2;

public class Staff extends Employees{

    private String work;

    public Staff(String fullName, Long age, String sex, String address,String work) {
        super(fullName, age, sex, address);
        this.work = work;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return super.toString() + " " + work;
    }
}
