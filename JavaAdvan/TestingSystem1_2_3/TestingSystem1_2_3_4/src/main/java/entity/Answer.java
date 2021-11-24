package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Answer",catalog = "TestingSystem")
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Answers")
    private short answers;

    @Column(name = "Content",length = 100,nullable = false)
    private String content;

    @ManyToOne()
    @JoinColumn(name = "QuestionID",referencedColumnName = "QuestionID",nullable = false)
    private Question questionID;

    @Column(name = "isCorrect",columnDefinition = "DEFAULT 1")
    private boolean isCorrect;

    public Answer() {
    }

    public short getAnswers() {
        return answers;
    }

    public void setAnswers(short answers) {
        answers = answers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        content = content;
    }

    public Question getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Question questionID) {
        questionID = questionID;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
