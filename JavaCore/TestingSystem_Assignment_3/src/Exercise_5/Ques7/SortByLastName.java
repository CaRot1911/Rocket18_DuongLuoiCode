package Exercise_5.Ques7;

import java.util.Comparator;

public class SortByLastName implements Comparator<Department> {


    @Override
    public int compare(Department o1, Department o2) {
        // lay ra khoang tran cuoi cung
        int lIndex1 = o1.name.lastIndexOf(' ');
        String lastWord1 = o1.name.substring(lIndex1+1);

        int lIndex2 = o2.name.lastIndexOf(' ');
        String lastWord2 = o2.name.substring(lIndex2+1);
        return lastWord1.compareTo(lastWord2);
    }
}
