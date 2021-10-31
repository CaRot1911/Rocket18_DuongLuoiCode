package Exception.Questions10;

import Exception.Questions11.InvalidAgeInputingException;

import java.util.Scanner;

public class Account {

    protected int idAcc;
    protected int age;
    protected String userName;
    protected String password;
    protected String createDate;

    public Account(int idAcc, int age, String userName, String password, String createDate) {
        this.idAcc = idAcc;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.createDate = createDate;
    }

    public Account() {
    }

    public int getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(int idAcc) {
        this.idAcc = idAcc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int inputAge() throws InvalidAgeInputingException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input age: ");
        int age = sc.nextInt();
        int Age=0;
        if(age > 0){
            age = Age;
        }else {
            throw new InvalidAgeInputingException("The age must be greater than 0");
        }
        return Age;
    }
    @Override
    public String toString() {
        return "ID: "+idAcc+"-"+"Usename: "+userName+"-"+"Age: "+age+"Password: "+password+"-"+"Createdate: "+createDate;
    }
}
