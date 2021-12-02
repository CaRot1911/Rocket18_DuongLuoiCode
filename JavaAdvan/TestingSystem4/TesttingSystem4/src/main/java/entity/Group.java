package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Group",catalog = "TestingSystem")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GroupID")
    private short groupID;

    @Column(name = "GroupName",length = 50,nullable = false,unique = true)
    private String groupName;

    @ManyToOne()
    @JoinColumn(name = "CreatorID",referencedColumnName = "AccountID",updatable = false)
    private Account creatorID;

    @Column(name = "CreateDate",columnDefinition = "DEFAULT NOW()",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public Group() {
    }

    public short getGroupID() {
        return groupID;
    }

    public void setGroupID(short groupID) {
        groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        groupName = groupName;
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
