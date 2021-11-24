package repository;


import entity.Position;
import hibernatConfig.HibernateUtils;
import javafx.geometry.Pos;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PositionRepository {

    public List<Position> getAllPosition(){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Query<Position> query = session.createQuery("FROM Position ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createPosition(Position position){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(position);
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public Position getPositionById(short id){
        Session session = null;

        try {
            session = HibernateUtils.getInstance().openSession();

            Position position =session.get(Position.class,id);

            return position;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public Position getPositionByName(String name){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Position> query = session.createQuery("FROM Position WHERE PositionName = :pra");

            query.setParameter("pra",name);

            Position position = query.uniqueResult();

            return position;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    public void deletePosition(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Position position = session.load(Position.class,id);

            session.delete(position);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
