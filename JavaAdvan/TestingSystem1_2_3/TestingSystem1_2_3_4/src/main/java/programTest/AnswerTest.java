package programTest;

import entity.Answer;
import repository.AnswerRepository;

import java.util.List;

public class AnswerTest {

    public static void main(String[] args) {

        AnswerRepository answerRepository = new AnswerRepository();

        List<Answer> answerList = answerRepository.getAllAnswer();
        for(Answer answer : answerList){
            System.out.println(answer.getAnswers() + "-" +answer.getQuestionID().getQuestionID()+"-"+answer.getContent());
        }
    }
}
