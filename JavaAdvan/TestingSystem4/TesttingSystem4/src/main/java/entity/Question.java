package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Question",catalog = "TestingSystem")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestionID")
    private short questionID;

    @Column(name = "Content",length = 100,nullable = false)
    private  String content;

    @ManyToOne()
    @JoinColumn(name = "CategoryID",referencedColumnName = "CategoryID",nullable = false)
    private CategoryQuestion categoryID;

    @ManyToOne()
    @JoinColumn(name = "TypeID",referencedColumnName = "TypeID",nullable = false)
    private TypeQuestion typeID;

    @OneToOne()
    @JoinColumn(name = "CreatorID",referencedColumnName = "AccountID",nullable = false,unique = true,updatable = false)
    private Account creatorID;

    @Column(name = "CreateDate",columnDefinition = "DEFAULT NOW()",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public Question() {
    }

    public short getQuestionID() {
        return questionID;
    }

    public void setQuestionID(short questionID) {
        questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        content = content;
    }

    public CategoryQuestion getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryQuestion categoryID) {
        categoryID = categoryID;
    }

    public TypeQuestion getTypeID() {
        return typeID;
    }

    public void setTypeID(TypeQuestion typeID) {
        typeID = typeID;
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
