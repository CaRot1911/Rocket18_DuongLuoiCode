package repository;

import entity.Employee;
import entity.Manager;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ManagerRepository {

    public List<Manager> getListManager(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Manager> query = session.createQuery("FROM Manager ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createManager(Manager manager){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(manager);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateManager(short id, short managementNumberOfYear){

        Session session= null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();
            Manager manager = session.load(Manager.class,id);

            manager.setManagementNumberOfYear(managementNumberOfYear);

            session.update(manager);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteManager(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Manager manager = session.load(Manager.class,id);

            session.delete(manager);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
