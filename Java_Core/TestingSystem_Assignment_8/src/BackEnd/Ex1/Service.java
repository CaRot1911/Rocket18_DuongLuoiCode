package BackEnd.Ex1;

import Entity.Ex1.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    public void Questions1(){
        int count = 0;
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Duong"));
        studentList.add(new Student("Huy"));
        studentList.add(new Student("Dung"));
        studentList.add(new Student("Duong"));
        studentList.add(new Student("Duong"));
        studentList.add(new Student("Hung"));

        // count list
        for (Student elem : studentList){
            count++;
        }
        System.out.println("Tổng số: " + count);
        System.out.println("================================");

        // Student is index = 4
        System.out.println(studentList.get(3).toString());
        System.out.println("================================");

        // In ra phần tử đầu và phần tử cuối của students
        System.out.println(studentList.get(0).toString());
        System.out.println(studentList.get(5).toString());
        System.out.println("================================");

        // Thêm 1 phần tử vào vị trí đầu,cuối của students
        studentList.add(0,new Student("Vu"));
        studentList.add(7,new Student("Trang"));
        for(Student elem : studentList){
            System.out.println(elem.toString());
        }
        System.out.println("================================");

        //Đảo ngược vị trí của students
        Collections.reverse(studentList);
        System.out.println("After: " );
        for (Student elem : studentList){
            System.out.println(elem);
        }
        System.out.println("================================");

        //Tạo 1 method tìm kiếm student theo name
        for (Student elem : studentList){
            elem.searchID(8);
        }
        System.out.println("================================");

        //Tạo 1 method để in ra các student có trùng tên
        for (Student elem : studentList){
            elem.DisplayName("Duong");
        }
        System.out.println("================================");

        //Xóa name của student có id = 2
        int index = -1;
        for(int i=0;i<studentList.size();i++){
            if(studentList.get(i).getId() == 2){
                index = i;
            }
        }
        if (index > -1){
            studentList.set(index,new Student(null));
        }
        for(Student elem : studentList){
            System.out.println(elem.toString());
        }
        System.out.println("================================");

        // Delete student có id = 5;
        for (int i =0;i<studentList.size();i++){
            if (studentList.get(i).getId() == 5){
                index = i;
            }
        }
        if(index > -1){
            studentList.remove(index);
        }
        System.out.println("================================");

        //Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
        //studentCopies
        ArrayList<Student> studentCopies = new ArrayList<>();
        studentCopies.addAll(studentList);
        for (Student elem : studentCopies){
            System.out.println(elem);
        }

    }
}
