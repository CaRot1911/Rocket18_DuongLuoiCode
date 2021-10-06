package Exception.Questions8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {
    public static int inputInt(){
        Scanner sc = new Scanner(System.in);
        String strNum = sc.next();
        int num = 0;

        try {
            num = Integer.parseInt(strNum);
        }catch (NumberFormatException | InputMismatchException e){
            System.out.println("Not Integer");
        }
        return num;
    }

    public static float inputFloat(){
        Scanner sc = new Scanner(System.in);
        String strNum = sc.next();
        float num = 0;

        try {
            num = Float.parseFloat(strNum);
        }catch (NumberFormatException e){
            System.out.println("Not Float");
        }
        return num;
    }

    public static String inputString(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        return str;
    }
}
