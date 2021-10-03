package Exercise_2_Polymorphism;

import Exercise_2_Polymorphism.Question_1.Student;

import java.util.ArrayList;

public class Ques1 {

    public static void main(String[] args) {

        Student student = new Student(1l,"Dương",1);
        Student student1 = new Student(2l,"Dương",1);
        Student student2 = new Student(3l,"Dương",1);
        Student student3 = new Student(4l,"Dương",2);
        Student student4 = new Student(5l,"Dương",2);
        Student student5 = new Student(6l,"Dương",2);
        Student student6 = new Student(7l,"Dương",3);
        Student student7 = new Student(8l,"Dương",3);
        Student student8 = new Student(9l,"Dương",3);
        Student student9 = new Student(10l,"Dương",3);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(student);
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.add(student4);
        studentArrayList.add(student5);
        studentArrayList.add(student6);
        studentArrayList.add(student7);
        studentArrayList.add(student8);
        studentArrayList.add(student9);


        // b) Kêu gọi cả lớp điểm danh.
        for (Student elem : studentArrayList){
            elem.diemDanh();
        }

        // c) Gọi nhóm 1 đi học bài
        for (Student elem : studentArrayList){
            if(elem.getGroup()==1){
                elem.hocBai();
            }
        }

        // Gọi nhóm 2 đi dọn vệ sinh
        for (Student elem : studentArrayList){
            if(elem.getGroup() == 2){
                elem.donVeSinh();
            }
        }
    }
}
