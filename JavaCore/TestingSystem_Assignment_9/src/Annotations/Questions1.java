package Annotations;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Questions1 {

    @Deprecated
    public static void main(String[] args) throws ParseException {

        Date date = DateFormat.getInstance().parse("18/05/2020");
        System.out.println(date);
    }
}
