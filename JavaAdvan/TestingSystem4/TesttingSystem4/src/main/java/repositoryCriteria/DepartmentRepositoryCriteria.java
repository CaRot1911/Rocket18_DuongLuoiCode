package repositoryCriteria;

import entity.Department;
import entity.DetailDepartment;
import hibernatConfig.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DepartmentRepositoryCriteria {

    public void createDepartment(Department department){
        Session session = null;
        try {
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
    public List<Department> getAllDepartment(String DepName,String EmulationPoints,String page,String size){
        Session session = null;
        List<Department> departmentList = null;
        try {
            session  = HibernateUtils.getInstance().openSession();
            if(DepName == null && EmulationPoints == null && page == null && size == null){
                Criteria cr = session.createCriteria(Department.class);
                cr.addOrder(Order.asc("departmentID"));

                departmentList = cr.list();
            }else if(DepName != null && EmulationPoints == null && page == null && size == null){
                Criteria criteria = session.createCriteria(Department.class);
                criteria.addOrder(Order.asc("departmentID"));
                criteria.add(Restrictions.ilike("departmentName",DepName));

                departmentList = criteria.list();
            }else if(DepName == null && EmulationPoints != null && page == null && size == null){
                Criteria cr = session.createCriteria(Department.class);
                Criteria criteria = cr.createCriteria("detailDepartment");

                short i = Short.parseShort(EmulationPoints);

                criteria.add(Restrictions.eq("emulationPoint",i));
                criteria.addOrder(Order.asc("departmentID"));

                departmentList = criteria.list();
            }else if(DepName == null && EmulationPoints == null && page != null && size != null){

                Criteria cr = session.createCriteria(Department.class);

                short i = Short.parseShort(page);
                short j = Short.parseShort(size);

                short offset = (short) ((i-1)*j);
                short limit = j;

                cr.setFirstResult(offset);
                cr.setMaxResults(limit);
                cr.addOrder(Order.asc("departmentID"));

                departmentList = cr.list();
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
        try {
            long count = 0;
            List<Department> lst = null;
            session = HibernateUtils.getInstance().openSession();
            Criteria cr = session.createCriteria(Department.class);
            if(DepName == null && EmulationPoints == null){

//                dem so cot
                cr.setProjection(Projections.rowCount());

                count = (long) cr.uniqueResult();

            }else if(DepName != null && EmulationPoints == null){

                cr.setProjection(Projections.rowCount());
                cr.add(Restrictions.ilike("departmentName",DepName));

                count = (long) cr.uniqueResult();
            }else {
                short i = Short.parseShort(EmulationPoints);
                cr.setProjection(Projections.rowCount());
                cr.add(Restrictions.eq("Department.detailDepartment.emulationPoint",i));

                count = (long) cr.uniqueResult();
            }
            return count;
        }finally {
            if(session !=null){
                session.close();
            }
        }
    }

    public Department getDepartmentById(short id){

        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Criteria cr = session.createCriteria(Department.class);

            cr.add(Restrictions.eq("departmentID",id));

            Department department  = (Department) cr.uniqueResult();

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

            Criteria cr = session.createCriteria(Department.class);

            cr.add(Restrictions.like("departmentName",name));

            Department department = (Department) cr.uniqueResult() ;

            return department;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void updateDepartment(short id,String newName){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(Department.class);

            cr.add(Restrictions.like("departmentID",id));

            Department department = (Department) cr.uniqueResult();
            department.setDepartmentName(newName);
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
        try {
            session = HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            Criteria cr = session.createCriteria(Department.class);
            cr.add(Restrictions.eq("departmentID",id));

            Department department = (Department) cr.uniqueResult();

            session.delete(department);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public boolean isGetDepartmentByID(short id){
        Department department = getDepartmentById(id);
        if (department != null){
            return  true;
        }
        return false;
    }

    public boolean isGetDepartmentByName(String name){
        Department department = getDepartmentByName(name);

        if(department != null){
            return true;
        }
        return false;
    }
}
