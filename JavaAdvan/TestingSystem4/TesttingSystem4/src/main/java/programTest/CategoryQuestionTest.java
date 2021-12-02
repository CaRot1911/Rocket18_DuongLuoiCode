package programTest;

import entity.CategoryQuestion;
import repository.CategoryQuestionRepository;

import java.util.List;

public class CategoryQuestionTest {

    public static void main(String[] args) {

        CategoryQuestionRepository categoryQuestionRepository = new CategoryQuestionRepository();

        List<CategoryQuestion> categoryQuestionList = categoryQuestionRepository.getAllCategoryQuestion();

        for (CategoryQuestion categoryQuestion : categoryQuestionList){
            System.out.println(categoryQuestion.getCategoryID() + "-" + categoryQuestion.getCategoryName());
        }
    }
}
