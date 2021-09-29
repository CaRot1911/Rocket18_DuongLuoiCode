package Exercise_5.Ques5;


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

        for (int i=0;i<2;i++){
            if(departmentList.get(0).name.length() == departmentList.get(1).name.length()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            break;
        }
    }
}
