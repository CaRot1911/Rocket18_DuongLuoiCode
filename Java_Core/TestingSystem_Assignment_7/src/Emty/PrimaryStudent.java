package Emty;

public class PrimaryStudent extends Student{

    public static int count2 = 0;
    public PrimaryStudent(String name) throws Exception {
        super(name);
        count2++;
    }
}
