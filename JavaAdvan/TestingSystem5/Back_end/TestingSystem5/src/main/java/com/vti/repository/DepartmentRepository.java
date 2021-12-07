package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository{


    @Override
    public void createDepartments(Department department) {
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

    @Override
    public List<Department> getAllDepartments() {
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            Query<Department> departmentQuery = session.createQuery("FROM Department ORDER BY departmentID");

            return departmentQuery.list();
        }finally {
            if(session !=null){
                session.close();
            }
        }
    }

    @Override
    public Department getDepartmentByID(int DepID) {
        Session session = null;

        try {
            session = HibernateUtils.getInstance().openSession();

            Department department = session.get(Department.class,DepID);
            return department;
        }finally {
            if(session != null){
                session.close();
            }
        }

    }

    @Override
    public Department getDepartmentByName(String DepName) {
        Session session = null;

        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Department> query = session.createQuery("FROM Department WHERE departmentName = :pra");
            query.setParameter("pra",DepName);

            return query.uniqueResult();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
    @Override
    public void updateDepartment(int id, String newName) {
        Session session = null;
        try{
            session =HibernateUtils.getInstance().openSession();

            session.beginTransaction();
            Department department = session.load(Department.class,id);

            department.setDepartmentName(newName);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
    @Override
    public void updateDepartments(Department department) {
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            session.update(department);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }



    @Override
    public void deleteDepartment(int DepID) {
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            Department department = session.get(Department.class,DepID);

            session.delete(department);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public boolean isDepartmentExistsByID(int DepID) {
        Department department = getDepartmentByID(DepID);
        if(department != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean isDepartmentExistsByName(String DepName) {
        Department department = getDepartmentByName(DepName);
        if(department != null){
            return true;
        }
        return false;
    }
}
