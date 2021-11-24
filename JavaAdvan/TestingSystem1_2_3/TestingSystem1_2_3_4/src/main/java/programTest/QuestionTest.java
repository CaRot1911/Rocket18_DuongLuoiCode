package programTest;

import entity.Question;
import repository.QuestionRepository;

import java.util.List;

public class QuestionTest {
    public static void main(String[] args) {

        QuestionRepository questionRepository = new QuestionRepository();

        List<Question> questionList = questionRepository.getAllQuestion();

        for (Question question : questionList){
            System.out.println(question.getQuestionID()+"-"+question.getCategoryID().getCategoryID());
        }
    }
}
