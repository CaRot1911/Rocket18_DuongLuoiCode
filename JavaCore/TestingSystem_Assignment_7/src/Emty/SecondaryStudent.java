package Emty;

public class SecondaryStudent extends Student{
    public static int counts = 0;
    public SecondaryStudent(String name) throws Exception {
        super(name);
        counts++;
    }
}
