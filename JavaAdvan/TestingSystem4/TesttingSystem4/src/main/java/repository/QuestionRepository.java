package repository;


import entity.Question;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionRepository {

    public List<Question> getAllQuestion(){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Query<Question> query = session.createQuery("FROM Question ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createQuestion(Question question){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(question);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateQuestion(short id, String content){

        Session session;
        session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();
            Question question = session.load(Question.class,id);

            question.setContent(content);

            session.update(question);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteQuestion(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Question question = session.load(Question.class,id);

            session.delete(question);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
