package entity;

import PKCustom.PKGroupAccount;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GroupAccount",catalog = "TestingSystem")
public class GroupAccount implements Serializable {

    @EmbeddedId
    private PKGroupAccount id;


    @ManyToOne
    @MapsId("AccountID")
    @JoinColumn(name = "AccountID")
    private  Account account;

    @ManyToOne
    @MapsId("GroupID")
    @JoinColumn(name = "GroupID")
    private Group group;


    @Column(name = "JoinDate",columnDefinition = "DEFAULT NOW()")
    @Temporal(TemporalType.TIMESTAMP)
    private Date JoinDate;


    public GroupAccount() {
    }

    public PKGroupAccount getId() {
        return id;
    }

    public void setId(PKGroupAccount id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(Date joinDate) {
        JoinDate = joinDate;
    }
}
