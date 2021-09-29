package Exercise4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_4 {
    public Scanner sc = new Scanner(System.in);
    public String outPut;

    Exercise_4() {

    }

    void Question_1() {
        String s = "";
        int count = 0;
        String str = "    I am Duong   ";
        String strNew = str.trim();
        String[] strCut = strNew.split(" ");
        for (int i = 0; i < strCut.length; i++) {
            count++;
            System.out.print(s.concat(strCut[i] + " "));
        }
        System.out.println("Count: " + count);

    }

    void Question_2() {
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(str1.concat(" " + str2));
    }

    void Question_3() {
        String str = sc.nextLine();
        String s = str.substring(0, 1);
        String s2 = str.substring(1);
        System.out.println(s2);
        if (s.equals(s.toUpperCase()) == false) {
            System.out.println(s.toUpperCase().concat(s2));
        } else {
            System.out.println(str);
        }
    }

    void Question_4() {
        String str = sc.nextLine();
        ArrayList<String> strNew = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            strNew.add(str.substring(i, i + 1));
        }
        for (String elem : strNew) {
            System.out.println("Ki tu thu 1 la: " + elem.toUpperCase());
        }

    }

    void Question_5() {
        System.out.println("First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Last Name: ");
        String lastName = sc.nextLine();

        System.out.println("Full Name: " + firstName.concat(" " + lastName));

    }

    void Question_6() {
        System.out.println("Full name: ");
        String fullName = sc.nextLine();
        String fullNameNew = fullName.trim();
        String[] outPut = fullNameNew.split(" ");
        String lastName = outPut[0];
        String middleName = outPut[1];
        String firstname = outPut[2];
        System.out.println("Last Name: " + lastName);
        System.out.println("Middle name: " + middleName);
        System.out.println("First Name: " + firstname);

    }

    void Question_7() {
        System.out.println("Full Name: ");
        String fullName = sc.nextLine();
        String fulNameNew = fullName.trim(); // Delete " "
        String[] fullNameCut = fulNameNew.split(" ");
        String lastName = fullNameCut[0];
        String middleName = fullNameCut[1];
        String firstName = fullNameCut[2];
        // Chưa xử lý được tên người có hai chữ học đệm
        // Xủ lý Họ
        String str0 = lastName.substring(0, 1);
        String str1 = lastName.substring(1);
        String lastNameNew = str0.toUpperCase().concat(str1);

        // Xử lý Tên Đệm
        String str2 = middleName.substring(0, 1);
        String str3 = middleName.substring(1);
        String middleNameNew = str2.toUpperCase().concat(str3);

        // Xử lý tên
        String str4 = firstName.substring(0, 1);
        String str5 = firstName.substring(1);
        String firstNameNew = str4.toUpperCase().concat(str5);

        System.out.println(lastNameNew.concat(" " + middleNameNew).concat(" " + firstNameNew));
    }

    void Question_8() {
        String str = "Java";
        Group group = new Group();
        if (str.equals(group.groupName) == true) {
            System.out.println(group.groupID);
            System.out.println(group.groupName);
        }

    }

    void Question_9() {
        String str = "Java";
        Group group = new Group();
        if (str.equals(group.groupName) == true) {
            System.out.println(group.groupID);
            System.out.println(group.groupName);
        }
    }

    void Question_10() {
        String str = "hello";
        str = (str.toLowerCase()).trim();
        String str1 = "olleh";
        str1 = (str1.toLowerCase()).trim();

        char[] newStr = str.replaceAll("", "").toCharArray();
        char[] newStr1 = str1.replaceAll("", "").toCharArray();
        Arrays.sort(newStr);
        Arrays.sort(newStr1);

        if (Arrays.equals(newStr, newStr1) == true) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
        }

    }

    void Question_11() {
        String str = "aaaasdsdsffffss";
        char c = 'a';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("Count : " + count);
    }

    void Question_12() {
        String str = "manh duong";
        // convert string -> byte
        byte[] newString = str.getBytes();
        byte[] result = new byte[newString.length];

        for (int i = 0; i < newString.length; i++) {
            result[i] = newString[newString.length - i - 1];
        }
        System.out.println((new String(result)));

    }

    void Question_13() {
        int count = 0;
        String str = sc.next();
        if (str == null) System.out.println("false");

        if (str != null) {
            char[] c = str.toCharArray();
            for (char f : c) {
                if (Character.isDigit(f) == true) {
                    count++;

                }
            }
            if (count > 0) System.out.println("false");
            else System.out.println("true");
        }
    }

    void Question_14() {
        String str = "VTI Academy";
        System.out.println(str.replaceAll("e", "*"));
    }

    void Question_15() {
        String str = " I am developer ";
        str = str.trim();
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer.reverse());
    }

    void Question_16() {
        System.out.println("Enter String");
        String str = sc.next();
        System.out.println("Enter n cut: ");
        int n = sc.nextInt();
        if(str.length()%n != 0){
            System.out.println("KO");
        }else
        {
            String[] s = new String[str.length()/n];
            // chua nghi duoc thuat toan

        }
    }




    public static void main(String[] args) {

    Exercise_4 ex = new Exercise_4();

    //ex.Question_1();
    //ex.Question_2();
    //ex.Question_3();
    //ex.Question_4();
    //ex.Question_5();
    //ex.Question_6();
    //ex.Question_7();
    //ex.Question_8();
    //ex.Question_9();
    //ex.Question_10();
    //ex.Question_11();
    //ex.Question_12();
    //ex.Question_13();
    //ex.Question_14();
    //ex.Question_15();
    ex.Question_16();
    }
}
