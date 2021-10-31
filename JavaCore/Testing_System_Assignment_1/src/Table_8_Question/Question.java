package Table_8_Question;

import Table_3_Account.Account;
import Table_6_TypeQuestion.TypeQuestion;
import Table_7_CategoryQuestion.CategoryQuestion;

public class Question {
    public int questionID;
    String content;
    CategoryQuestion categoryID;
    TypeQuestion typeID;
    Account accountID;
    String createDate;

    Question() {

    }

    public Question(int questionID, String content, CategoryQuestion categoryID, TypeQuestion typeID, Account accountID, String createDate) {
        this.questionID = questionID;
        this.content = content;
        this.categoryID = categoryID;
        this.typeID = typeID;
        this.accountID = accountID;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", content='" + content + '\'' +
                ", categoryID=" + categoryID.categoryID +
                ", typeID=" + typeID.typeID +
                ", accountID=" + accountID.AccountID +
                ", createDate=" + createDate +
                '}';
    }
}
