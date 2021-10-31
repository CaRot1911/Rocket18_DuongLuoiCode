package Exercise_2_Polymorphism;

import Exercise_2_Polymorphism.Question_2.Student;

import java.util.ArrayList;
import java.util.List;

public class Test_Ques2_Ex2 {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        Student std = new Student();
        std.inputInfo();
        studentList.add(std);

        for (Student elem : studentList){
            elem.hocBong();
        }

    }
}
