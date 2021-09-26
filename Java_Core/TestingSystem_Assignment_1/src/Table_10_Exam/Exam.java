package Table_10_Exam;

import Table_3_Account.Account;
import Table_7_CategoryQuestion.CategoryQuestion;


public class Exam {
    public int examID;
    int code;
    String title;
    CategoryQuestion categoryID;
    int duration;
    Account accountID;
    String createDate;

    Exam(){

    }

    public Exam(int examID, int code, String title, CategoryQuestion categoryID, int duration, Account accountID, String createDate){
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.categoryID = categoryID;
        this.duration = duration;
        this.accountID = accountID;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examID=" + examID +
                ", code=" + code +
                ", title='" + title + '\'' +
                ", categoryID=" + categoryID.categoryID +
                ", duration=" + duration +
                ", accountID=" + accountID.AccountID +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
