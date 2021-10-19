package DateFormat;



public class Exam {
    public int examID;
    int code;
    String title;
    int duration;
    String createDate;

    Exam() {

    }

    public Exam(int examID, int code, String title ,int duration , String createDate) {
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.duration = duration;
        this.createDate = createDate;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
