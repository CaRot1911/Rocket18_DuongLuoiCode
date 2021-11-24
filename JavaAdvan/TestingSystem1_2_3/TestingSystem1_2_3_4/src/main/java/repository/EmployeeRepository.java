package repository;


import entity.Employee;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeRepository {

    public List<Employee> getListEmployee(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Employee> query = session.createQuery("FROM Employee ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void createEmployee(Employee employee){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(employee);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateEmployee(short id,short workingNumberOfYear){

        Session session;
        session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();
            Employee employee = session.load(Employee.class,id);

            employee.setWorkingNumberOfYear(workingNumberOfYear);
            session.update(employee);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteEmployee(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Employee employee = session.load(Employee.class,id);

            session.delete(employee);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
