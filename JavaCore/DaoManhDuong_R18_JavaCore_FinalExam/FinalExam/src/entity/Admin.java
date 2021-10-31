package entity;

public class Admin extends User{
    private int expInYears;

    public Admin(String id, String fullName, String email, String password, int expInYears) {
        super(id, fullName, email, password);
        this.expInYears = expInYears;
    }

    public int getExpInYears() {
        return expInYears;
    }

    public void setExpInYears(int expInYears) {
        this.expInYears = expInYears;
    }

    @Override
    public String toString() {
        return super.toString()+"-" + "ExpInYears: "+getExpInYears();
    }
}
