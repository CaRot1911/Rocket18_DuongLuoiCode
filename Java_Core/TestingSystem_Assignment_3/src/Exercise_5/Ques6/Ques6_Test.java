package Exercise_5.Ques6;

import Exercise_5.Ques7.Department;
import Exercise_5.Ques7.SortByLastName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ques6_Test {
    public static void main(String[] args) {
        List<Exercise_5.Ques7.Department> departmentList = new ArrayList<>();

        departmentList.add(new Exercise_5.Ques7.Department(1,"Boss of director"));
        departmentList.add(new Exercise_5.Ques7.Department(2,"Marketing"));
        departmentList.add(new Exercise_5.Ques7.Department(3,"Accounting"));
        departmentList.add(new Exercise_5.Ques7.Department(4,"Sale"));
        departmentList.add(new Exercise_5.Ques7.Department(5,"waiting room"));

        for (Exercise_5.Ques7.Department d : departmentList){
            System.out.println(d.name);
        }
        Collections.sort(departmentList,new SortByLastName());

        for (Department d : departmentList){
            System.out.println(d.name);
        }
    }
}
