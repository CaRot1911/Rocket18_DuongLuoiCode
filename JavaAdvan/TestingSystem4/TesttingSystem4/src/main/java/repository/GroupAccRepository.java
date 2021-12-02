package repository;

import entity.GroupAccount;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupAccRepository {

    public List<GroupAccount> getAllGroupAcc(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<GroupAccount> query =session.createQuery("FROM GroupAccount ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
    public void createGroupAccount(GroupAccount groupAccount){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(groupAccount);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateGroupAccount(GroupAccount groupAccount){

        Session session;
        session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            session.update(groupAccount);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteGroupAccount(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            GroupAccount groupAccount = session.load(GroupAccount.class,id);

            session.delete(groupAccount);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
