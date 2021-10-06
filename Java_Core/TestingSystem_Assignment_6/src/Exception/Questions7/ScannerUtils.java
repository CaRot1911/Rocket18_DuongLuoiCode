package Exception.Questions7;

import java.util.Scanner;

public class ScannerUtils {
    public static int inputAge(String errorMessage){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input age: ");
        String age = sc.next();
        boolean check;
        int Age = 0;

        try {
            Age = Integer.parseInt(age);
            if (Age > 0){
                check = true;
            }else{
                System.out.println(errorMessage);
            }
        }catch (NumberFormatException e){
            System.out.println(errorMessage);
        }
        return Age;
    }
}
