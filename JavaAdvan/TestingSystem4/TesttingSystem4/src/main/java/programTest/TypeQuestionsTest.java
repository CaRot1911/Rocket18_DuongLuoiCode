package programTest;

import entity.TypeQuestion;
import repository.TypeQuesRepository;

import java.util.List;

public class TypeQuestionsTest {

    public static void main(String[] args) {

        TypeQuesRepository typeQuesRepository = new TypeQuesRepository();

        List<TypeQuestion> typeQuestionList = typeQuesRepository.getAllTypeQuestion();

        for (TypeQuestion typeQuestion : typeQuestionList){
            System.out.println(typeQuestion.getTypeID() + "-" + typeQuestion.getTypeName());
        }
    }
}
