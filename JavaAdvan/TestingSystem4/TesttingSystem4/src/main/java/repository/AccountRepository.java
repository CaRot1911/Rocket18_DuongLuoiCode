package repository;

import entity.Account;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class AccountRepository {


    public List<Account> getListAccount(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Account> query = session.createQuery("FROM Account ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void crateAccount(Account account){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(account);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public Account getAccountGetById(short id){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Account account = session.get(Account.class,id);

            return account;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public Account getAccountGetUserName(String username){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Query<Account> query = session.createQuery("FROM Account WHERE Username = :pramarter" );
            query.setParameter("pramarter",username);

            Account account = query.uniqueResult();
            return account;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void updateAccount(short id,Account account){
        Session session = null;
        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();

             account = session.load(Account.class,id);


            session.update(account);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteAccount(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Account account = session.load(Account.class,id);

            session.delete(account);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
