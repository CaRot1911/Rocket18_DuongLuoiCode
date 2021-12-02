package entity;


import PKCustom.PKExamQuestion;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ExamQuestion",catalog = "TestingSystem")
public class ExamQuestion implements Serializable {

    @EmbeddedId
    private PKExamQuestion id;

    @ManyToOne()
    @JoinColumn(name = "ExamID",referencedColumnName = "ExamID",nullable = false,unique = true,insertable = false,updatable = false)
    private Exam examID;

    @ManyToOne()
    @JoinColumn(name = "QuestionID",referencedColumnName = "QuestionID",nullable = false,unique = true,insertable = false,updatable = false)
    private Question questionID;

    public ExamQuestion() {
    }

    public PKExamQuestion getId() {
        return id;
    }

    public void setId(PKExamQuestion id) {
        this.id = id;
    }

    public Exam getExamID() {
        return examID;
    }

    public void setExamID(Exam examID) {
        examID = examID;
    }

    public Question getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Question questionID) {
        questionID = questionID;
    }
}
