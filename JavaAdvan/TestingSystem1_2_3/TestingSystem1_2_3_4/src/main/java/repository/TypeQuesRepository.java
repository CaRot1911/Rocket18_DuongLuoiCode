package repository;

import entity.TypeQuestion;
import enumConfig.TypeQuesEnum;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TypeQuesRepository {

    public List<TypeQuestion> getAllTypeQuestion(){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Query<TypeQuestion> query= session.createQuery("FROM TypeQuestion ");

            return query.list();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createTypeQuestion(TypeQuestion typeQuestion){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(typeQuestion);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateTypeQuestion(short id, TypeQuesEnum type){

        Session session;
        session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            TypeQuestion typeQuestion = session.load(TypeQuestion.class,id);

            typeQuestion.setTypeName(type);

            session.update(typeQuestion);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteTypeQuestion(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            TypeQuestion typeQuestion = session.load(TypeQuestion.class,id);

            session.delete(typeQuestion);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
