package programTest;

import entity.Exam;
import repository.ExamRepository;

import java.util.List;

public class ExamTest {

    public static void main(String[] args) {

        ExamRepository examRepository = new ExamRepository();

        List<Exam> examList = examRepository.getAllExam();

        for (Exam exam :examList){
            System.out.println(exam.getCode());
        }
    }
}
