package Exception.Questions4;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static int getIndex(int index){
        return index;
    }
    public static void main(String[] args) {

        List<Department> departmentList = new ArrayList<>();

        departmentList.add(new Department(1,"DEV"));
        departmentList.add(new Department(2,"Sales"));
        departmentList.add(new Department(3,"PM"));
        /*for(Department elem : departmentList){
            System.out.println(elem.toString());
        }*/
        try {
            System.out.println(departmentList.get(getIndex(10)).toString());
        }catch (IndexOutOfBoundsException e){
            System.out.println("Cannot find department.");
        }
    }
}
