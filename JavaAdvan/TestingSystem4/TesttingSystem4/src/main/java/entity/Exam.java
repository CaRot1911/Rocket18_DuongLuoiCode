package entity;

import repository.ExamRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Exam",catalog = "TestingSystem")
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExamID")
    private short examID;

//    @GenericGenerator(name = "custom-code",strategy = "main.java.GeneratedCustom.CodeGenerated")
//    @GeneratedValue(generator = "custom-code" )
    @Column(name = "Code",nullable = false)
    private String code;

    @Column(name = "Title",length = 50,nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "CategoryID",referencedColumnName = "CategoryID",nullable = false)
    private CategoryQuestion categoryID;

    @Column(name = "Duration",nullable = false,columnDefinition = "INT DEFAULT 45")
    private short duration;

    @ManyToOne
    @JoinColumn(name = "CreatorID",referencedColumnName = "AccountID",nullable = false,updatable = false)
    private Account creatorID;

    @Column(name= "CreateDate",columnDefinition = "DEFAULT NOW()",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;



    @PrePersist
    public void beforeSaveToDataBase(){
        if(code == null){
            ExamRepository examRepository = new ExamRepository();

            String str;
            if(duration>=180){
                str = "L";

            }else if(duration >= 90){
                str = "M";
            }else {
                str = "S";
            }
            int count = examRepository.getTypeByDuration(duration);

            code = str + "-" + (count +1);
        }
    }
    public Exam() {
    }

    public short getExamID() {
        return examID;
    }

    public void setExamID(short examID) {
        examID = examID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public CategoryQuestion getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryQuestion categoryID) {
        categoryID = categoryID;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        duration = duration;
    }

    public Account getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Account creatorID) {
        creatorID = creatorID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        createDate = createDate;
    }

}
