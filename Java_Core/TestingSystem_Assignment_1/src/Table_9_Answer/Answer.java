package Table_9_Answer;

import Table_8_Question.Question;

public class Answer {
    public int answerID;
    String content;
    Question questionID;
    String isCorrect;

    Answer(){

    }

    public Answer(int answerID, String content, Question questionID, String isCorrect){
        this.answerID = answerID;
        this.content = content;
        this.questionID = questionID;
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerID=" + answerID +
                ", content='" + content + '\'' +
                ", questionID=" + questionID.questionID +
                ", isCorrect='" + isCorrect + '\'' +
                '}';
    }
}
