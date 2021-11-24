package repository;


import entity.CategoryQuestion;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryQuestionRepository {

    public List<CategoryQuestion> getAllCategoryQuestion(){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion ");
            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createCategoryQuestion(CategoryQuestion categoryQuestion){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(categoryQuestion);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateCategoryQuestion(short id, String categoryName){

        Session session;
        session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            CategoryQuestion categoryQuestion = session.load(CategoryQuestion.class,id);

            categoryQuestion.setCategoryName(categoryName);

            session.update(categoryQuestion);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteCategoryQuestion(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            CategoryQuestion categoryQuestion = session.load(CategoryQuestion.class,id);

            session.delete(categoryQuestion);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
