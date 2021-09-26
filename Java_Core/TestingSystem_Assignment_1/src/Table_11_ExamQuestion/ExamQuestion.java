package Table_11_ExamQuestion;

import Table_10_Exam.Exam;
import Table_8_Question.Question;

public class ExamQuestion {
    Exam examId;
    Question questionID;

    ExamQuestion(){

    }
    public ExamQuestion(Exam examId, Question questionID){
        this.examId = examId;
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "examId=" + examId.examID +
                ", questionID=" + questionID.questionID +
                '}';
    }
}
