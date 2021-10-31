package DateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

;

public class Demo {

    public static void main(String[] args) throws ParseException {

        Exam exam = new Exam(1,12345,"SQL",1,"22/10/2023");
        Exam exam1 = new Exam(2,12346,"Java",2,"22/09/2023");
        Exam exam2 = new Exam(3,12343,"Python",4,"22/09/2023");
        Exam exam3 = new Exam(4,12342,"MySQL",4,"22/09/2023");

        /*
            Questions 1
         */
        System.out.println("ID " + exam.getExamID());
        System.out.println("Code: " + exam.code);
        System.out.println("Code: " + exam.title);
        System.out.println("Duration: " + exam.duration);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(exam.getCreateDate());
        DateFormat dateFormat = DateFormat.getDateInstance(1, Locale.JAPAN);
        System.out.println("Create date : " + dateFormat.format(date));
        System.out.println("=============================================");
        /*
        Question 2:
         */
        ArrayList<Exam> exams = new ArrayList<>();
        exams.add(exam);
        exams.add(exam1);
        exams.add(exam2);
        exams.add(exam3);

        for (Exam elem : exams){
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/M/yyyy");
            Date date1 = simpleDateFormat1.parse(elem.getCreateDate());
            DateFormat D = DateFormat.getDateInstance(1,Locale.JAPAN);
            DateFormat T = DateFormat.getTimeInstance();
            System.out.println("Create date  : " + D.format(date1) +" "+ T.format(date1));
        }
        System.out.println("=============================================");
        /*
        Question 3:
         */
        for (Exam elem : exams){
            LocalDate localDate = LocalDate.parse(elem.getCreateDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println(localDate.getYear());
        }
        System.out.println("=============================================");
        /*
        Question 4
         */
        for (Exam elem : exams){
            LocalDate localDate = LocalDate.parse(elem.getCreateDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println(localDate.getMonth() + "-" +localDate.getYear());
        }
        System.out.println("=============================================");
        /*
        Question5
         */
        for (Exam elem : exams){
            LocalDate localDate = LocalDate.parse(elem.getCreateDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println(localDate.getMonth().getValue() + "-" +localDate.getYear());
        }

    }

}
