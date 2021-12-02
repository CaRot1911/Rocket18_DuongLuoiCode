package repository;


import entity.Department;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository{

    public List<Department> getAllDepartment(String DepName,String EmulationPoints,String page,String size){
        Session session = null;
        List<Department> departmentList = null;
        try {
            session = HibernateUtils.getInstance().openSession();
            if (DepName == null && EmulationPoints == null && page == null && size == null){
                Query<Department>  query = session.createQuery("FROM Department ORDER BY departmentID ASC");

                departmentList = query.list();
            }else if(DepName != null && EmulationPoints == null && page == null && size == null){
                Query<Department> query = session.createQuery("FROM Department WHERE departmentName = :pra ORDER BY departmentID ASC");
                query.setParameter("pra",DepName);

                departmentList = query.list();
            }else if(DepName == null && EmulationPoints != null && page == null && size == null){
                Query<Department> query = session.createQuery("FROM Department dep WHERE dep.detailDepartment.emulationPoint > :pra ORDER BY dep.departmentID ASC");
                short i = Short.parseShort(EmulationPoints);
                query.setParameter("pra",i);

                departmentList = query.list();
            }else if (DepName == null && EmulationPoints == null && page != null && size != null){
                Query<Department> query = session.createQuery("FROM Department ORDER BY departmentID ASC");

                short i = Short.parseShort(page);
                short j = Short.parseShort(size);
                short offset = (short) ((i-1) * j);
                short limit = j;

                query.setFirstResult(offset);
                query.setMaxResults(limit);

                departmentList = query.list();
            }
            return departmentList;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public long getCountDepartment(String DepName,String EmulationPoints){
        Session session = null;
        List<Department> departmentList = null;
        long count = 0;
        try {

            session = HibernateUtils.getInstance().openSession();
            if(DepName == null && EmulationPoints == null){

                Query<Long> query = session.createQuery("SELECT COUNT(departmentID) FROM Department");
                count = query.uniqueResult();

            }else if (DepName != null && EmulationPoints == null){
                Query<Long> query = session.createQuery("SELECT COUNT(departmentID) FROM Department WHERE departmentName = :pra");
                query.setParameter("pra",DepName);

                count = query.uniqueResult();
            }else if(DepName == null && EmulationPoints != null){
                Query<Long> query = session.createQuery("SELECT COUNT(dep.departmentID) FROM Department dep WHERE dep.detailDepartment.emulationPoint > :pra");

                short i = Short.parseShort(EmulationPoints);
                query.setParameter("pra",i);

                count = query.uniqueResult();
            }
            return count;
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
            session.beginTransaction();


            session.save(department);
            session.getTransaction().commit();
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

            Query<Department> query = session.createQuery("FROM Department WHERE departmentName = :pra");
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


            Department department = session.load(Department.class,id);
            session.beginTransaction();
            session.delete(department);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public boolean isDepartmentById( short id){
        Department department = getDepartmentById(id);
        if (department != null){
            return true;
        }
        return false;
    }

    public boolean isDepartmentByName(String name){
        Department department = getDepartmentByName(name);
        if(department != null){

            return true;
        }
        return false;
    }
}
