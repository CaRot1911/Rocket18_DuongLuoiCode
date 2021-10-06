package Exception;

import java.util.Scanner;

public class Questions5 {
    public static int inputAge(){
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
                System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
            }
        }catch (NumberFormatException e){
            System.out.println("wrong inputing! Please input an age as int, input again.");
        }
        return Age;
    }

    public static void main(String[] args) {
        inputAge();
    }
}
