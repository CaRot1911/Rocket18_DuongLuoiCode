import Table_10_Exam.Exam;
import Table_11_ExamQuestion.ExamQuestion;
import Table_1_Department.Department;
import Table_2_Position.Position;
import Table_3_Account.Account;
import Table_4_Group.Group;
import Table_5_GroupAccount.GroupAccount;
import Table_6_TypeQuestion.TypeQuestion;
import Table_7_CategoryQuestion.CategoryQuestion;
import Table_8_Question.Question;
import Table_9_Answer.Answer;


public class ProgramFile {
    public static void main(String[] args) {

        // Department
        Department dep1 = new Department(1,"Marketing");
        Department dep2 = new Department(2,"Sales");
        Department dep3 = new Department(3,"Room");

        // Position
        Position pos1 = new Position(1,"Dev");
        Position pos2 = new Position(2,"Test");
        Position pos3 = new Position(3,"PM");

        //Account
        Account acc = new Account(1,"abc@gamil.com","abc","abc",dep1,pos1,"2021/09/12");
        Account acc1 = new Account(1,"xyz@gamil.com","xyz","xyz",dep2,pos2,"2021/09/12");
        Account acc2 = new Account(1,"asd@gamil.com","asd","asd",dep3,pos3,"2021/09/12");

        //Group
        Group gr = new Group(1,"Class 1",acc,"2020/09/12");
        Group gr1 = new Group(2,"Class 2",acc1,"2020/09/12");
        Group gr2 = new Group(3,"Class 3",acc,"2020/09/12");

        //GroupAccount
        GroupAccount groupAccount = new GroupAccount(gr,acc,"2019/2/12");
        GroupAccount groupAccount1 = new GroupAccount(gr1,acc2,"2019/2/12");
        GroupAccount groupAccount2 = new GroupAccount(gr,acc,"2019/2/12");

        //TypeQuestions
        TypeQuestion tpe = new TypeQuestion(1,"Essay");
        TypeQuestion tpe1 = new TypeQuestion(2,"Multiple-Choice");

        //CategoryQuestion
        CategoryQuestion cques = new CategoryQuestion(1,"Java");
        CategoryQuestion cques1 = new CategoryQuestion(1,"SQL");
        CategoryQuestion cques2 = new CategoryQuestion(1,"Python");

        //Question

        Question ques1 = new Question(1,"Java OOP",cques,tpe,acc,"2019/2/15");
        Question ques2 = new Question(2,"SQL",cques1,tpe1,acc2,"2019/2/15");
        Question ques3 = new Question(3,"Mongo DB",cques,tpe,acc,"2019/2/15");

        //Answer
        Answer ans = new Answer(1,"Yes",ques1,"True");
        Answer ans1 = new Answer(2,"Yes",ques1,"False");
        Answer ans2 = new Answer(3,"Yes",ques1,"False");

        //Exam
        Exam ex = new Exam(1,192002,"JAVA",cques,60,acc, "2020/12/02");
        Exam ex1= new Exam(2,192003,"SQL",cques,60,acc, "2020/12/02");
        Exam ex2 = new Exam(3,192003,"PYTHON",cques,60,acc, "2020/12/02");

        //ExamQuestions
        ExamQuestion exQues = new ExamQuestion(ex,ques1);
        ExamQuestion exQues1 = new ExamQuestion(ex,ques1);
        ExamQuestion exQues2 = new ExamQuestion(ex,ques1);

        /*
            Questions 3:
        */
        System.out.println(dep1.toString());
        System.out.println(pos1.toString());
        System.out.println(acc.toString());
        System.out.println(gr.toString());
        System.out.println(groupAccount.toString());
        System.out.println(tpe.toString());
        System.out.println(cques.toString());
        System.out.println(ques1.toString());
        System.out.println(ans.toString());
        System.out.println(ex.toString());
        System.out.println(exQues.toString());

    }
}
