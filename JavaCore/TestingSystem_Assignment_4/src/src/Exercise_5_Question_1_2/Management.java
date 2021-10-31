package src.Exercise_5_Question_1_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    private List<Staff> staff;


    public Management(){
        staff = new ArrayList<>();
    }

    // add Staff
    public void addStaff(Staff staff1){
        staff.add(staff1);
    }

    // Show staff
    public void Display(){
        for (Staff elem : staff){
            System.out.println(elem.toString());
        }
    }

    //Search with name
    public void Search(){
        Integer count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name search: ");
        String searchName = sc.nextLine();
        searchName = searchName.toLowerCase();
        for (Staff elem : staff){
            //System.out.println(elem.getFullName().equals(searchName));
            if(elem.getFullName().toLowerCase().equals(searchName) == true){
                System.out.println(elem.toString());
                count++;
            }
            //System.out.println(elem.getFullName());
        }
        if (count == 0){
            System.out.println("No emp!!");
        }

    }

    //Delete with name
    public void DeleteName(){
        Integer count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name delete: ");
        String deleteName = sc.next();
        deleteName = deleteName.toLowerCase();
        for(Staff elem : staff){
            if(deleteName.equals(elem.getFullName().toLowerCase()) == true){
                staff.remove(elem);
                count ++;
            }
        }
        if(count == 0){
            System.out.println("No emp!!!");
        }
    }

    public List<Staff> getStaff() {
        return staff;
    }
}
