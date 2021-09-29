package Exercise_5.Ques7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ques7_Test {
    public static void main(String[] args) {

        List<Department> departmentList = new ArrayList<>();

        departmentList.add(new Department(1,"Boss of director"));
        departmentList.add(new Department(2,"Marketing"));
        departmentList.add(new Department(3,"Accounting"));
        departmentList.add(new Department(4,"Sale"));
        departmentList.add(new Department(5,"waiting room"));

        for (Department d : departmentList){
            System.out.println(d.name);
        }
        Collections.sort(departmentList,new SortByLastName());

        for (Department d : departmentList){
            System.out.println(d.name);
        }
    }
}
