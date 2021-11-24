package programTest;

import entity.Exam;
import entity.ExamQuestion;
import repository.ExamQuestionRepository;

import java.util.List;

public class ExamQuestionTest {

    public static void main(String[] args) {

        ExamQuestionRepository examQuestionRepository = new ExamQuestionRepository();

        List<ExamQuestion> examQuestionList = examQuestionRepository.getAllExamQuestion();

        for (ExamQuestion examQuestion : examQuestionList){
            System.out.println(examQuestion.getId());
        }

    }
}
