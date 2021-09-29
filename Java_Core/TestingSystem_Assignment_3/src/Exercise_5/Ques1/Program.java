package Exercise_5.Ques1;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Department> departmentList = new ArrayList<>();

        departmentList.add(new Department(1,"Boss of director"));
        departmentList.add(new Department(2,"Marketing"));
        departmentList.add(new Department(3,"Accounting"));
        departmentList.add(new Department(4,"Sale"));
        departmentList.add(new Department(5,"waiting room"));

        for (int i = 0;i<departmentList.size();i++){
            if (departmentList.get(i).id == 1){
                System.out.println(departmentList.get(i).toString());
            }
        }
    }
}
