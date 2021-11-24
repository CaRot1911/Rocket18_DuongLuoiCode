package repository;

import entity.Answer;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AnswerRepository {

    public List<Answer> getAllAnswer(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Answer> query = session.createQuery("FROM Answer ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createAnswer(Answer answer){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(answer);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateAnswer(short id,String content){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();
            session.beginTransaction();
            Answer answer = session.load(Answer.class,id);

            answer.setContent(content);

            session.save(answer);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteAnswer(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Answer answer = session.load(Answer.class,id);

            session.delete(answer);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}

