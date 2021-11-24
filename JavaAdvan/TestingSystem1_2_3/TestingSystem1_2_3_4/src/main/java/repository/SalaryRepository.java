package repository;


import entity.Salary;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SalaryRepository {

    public List<Salary> getAllSalary(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Salary> query = session.createQuery("FROM Salary ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createSalary(Salary salary){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(salary);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }


    public void deleteSalary(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Salary salary = session.load(Salary.class,id);

            session.delete(salary);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
