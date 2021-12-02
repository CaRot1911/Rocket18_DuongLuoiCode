package PKCustom;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PKExamQuestion implements Serializable {

    @Column(name = "ExamID",nullable = false)
    private short examID;

    @Column(name = "QuestionID",nullable = false)
    private short questionID;
}
