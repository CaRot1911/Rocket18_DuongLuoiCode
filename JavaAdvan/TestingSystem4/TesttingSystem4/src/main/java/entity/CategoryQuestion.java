package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CategoryQuestion" , catalog = "TestingSystem")
public class CategoryQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private  short categoryID;

    @Column(name = "CategoryName",length = 50,nullable = false,unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "categoryID")
    private List<Question> questionList;

    public CategoryQuestion() {
    }

    public short getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(short categoryID) {
        categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        categoryName = categoryName;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
