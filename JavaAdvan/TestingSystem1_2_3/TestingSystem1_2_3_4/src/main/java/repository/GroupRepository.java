package repository;

import entity.Group;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository {

    public List<Group> getAllGroup(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Group> query = session.createQuery("FROM Group ");

            return query.list();
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    public void createGroup(Group group){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(group);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateGroup(short id,String groupName){

        Session session;
        session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();
            Group group = session.load(Group.class,id);

            group.setGroupName(groupName);

            session.update(group);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteGroup(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Group group = session.load(Group.class,id);

            session.delete(group);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
