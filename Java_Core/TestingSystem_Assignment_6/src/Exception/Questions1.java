package Exception;

public class Questions1 {
    public static float devide(int a,int b){
        return (float)(a/b);
    }

    public static void main(String[] args) {
        try{
            float result = devide(7,0);
            System.out.println(result);
        }catch (ArithmeticException e){
            System.out.println("cannot divide 0");
        }
    }
}
