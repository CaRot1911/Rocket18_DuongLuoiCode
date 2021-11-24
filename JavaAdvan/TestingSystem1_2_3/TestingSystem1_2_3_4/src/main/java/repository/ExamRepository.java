package repository;

import entity.Exam;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ExamRepository {

    public short getTypeByDuration(short duration){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            String sql ;
            if (duration >= 180 ){
                sql = "SELECT COUNT(1) FROM Exam WHERE Duration >= 180";
            }else if(duration >= 90){
                sql = "SELECT COUNT(1) FROM Exam WHERE Duration >= 90 AND Duration < 180";
            }else {
                sql = "SELECT COUNT(1) FROM Exam WHERE Duration < 90";
            }
            Query<Long> query = session.createQuery(sql);

            return query.uniqueResult().shortValue();
        }finally {
            if(session != null){
                session.close();
            }
        }

    }

    public List<Exam> getAllExam(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Exam> query = session.createQuery("FROM Exam ");

            return query.getResultList();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createExam(Exam exam){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(exam);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateExam(short id,Exam exam){

        Session session;
        session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();
            exam = session.load(Exam.class,id);

            session.update(exam);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteExam(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Exam exam = session.load(Exam.class,id);

            session.delete(exam);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
