package repository;


import entity.Department;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {

    public List<Department> getAllDepartment(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Department>  query = session.createQuery("FROM Department ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createDepartment(Department department){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(department);
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public Department getDepartmentById(short id){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Department department = session.get(Department.class,id);

            return department;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public Department getDepartmentByName(String name){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Query<Department> query = session.createQuery("FROM Department WHERE DepartmentName = :pra");
            query.setParameter("pra",name);

            Department department = query.getSingleResult();
            return department;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    public void updateDepartment(short id, String departmentName){

        Session session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            Department department = session.load(Department.class,id);

            department.setDepartmentName(departmentName);

            session.update(department);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteDepartment(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Department department = session.load(Department.class,id);

            session.delete(department);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
