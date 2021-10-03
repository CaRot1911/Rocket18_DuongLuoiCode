package src.Exercise_5_Question_1_2;

public class Employees {
    private String fullName;
    private Long age;
    private String sex;
    private String address;

    public Employees(String fullName, Long age, String sex, String address) {
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return fullName + " " + age + " " + sex + " " + address;
    }
}
