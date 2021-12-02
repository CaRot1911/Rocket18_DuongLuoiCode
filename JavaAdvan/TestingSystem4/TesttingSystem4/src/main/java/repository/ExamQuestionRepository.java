package repository;

import entity.ExamQuestion;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ExamQuestionRepository {

    public List<ExamQuestion> getAllExamQuestion(){
        Session session = null;

        try {
            session = HibernateUtils.getInstance().openSession();

            Query<ExamQuestion> query = session.createQuery("FROM ExamQuestion ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
    public void createExamQuestion(ExamQuestion examQuestion){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(examQuestion);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void deleteExamQuestion(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            ExamQuestion examQuestion = session.load(ExamQuestion.class,id);

            session.delete(examQuestion);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
