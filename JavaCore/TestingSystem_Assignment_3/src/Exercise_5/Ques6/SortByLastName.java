package Exercise_5.Ques6;

import Exercise_5.Ques7.Department;

import java.util.Comparator;

public class SortByLastName implements Comparator<Exercise_5.Ques7.Department> {


    @Override
    public int compare(Exercise_5.Ques7.Department o1, Department o2) {

        String lastWord1 = o1.name.substring(0,1);

        String lastWord2 = o2.name.substring(0,1);
        return lastWord1.compareTo(lastWord2);
    }
}
