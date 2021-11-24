package repository;

import entity.DetailDepartment;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DetailDepartmentRepository {

    public List<DetailDepartment> getAllDetailDepartment(){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createDetailDepartment(DetailDepartment detailDepartment){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(detailDepartment);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateDetailDepartment(short id,short emulationPoint){

        Session session;
        session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            DetailDepartment detailDepartment = session.load(DetailDepartment.class,id);

            detailDepartment.setEmulationPoint(emulationPoint);

            session.update(detailDepartment);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteDetailDepartment(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            DetailDepartment detailDepartment = session.load(DetailDepartment.class,id);

            session.delete(detailDepartment);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
