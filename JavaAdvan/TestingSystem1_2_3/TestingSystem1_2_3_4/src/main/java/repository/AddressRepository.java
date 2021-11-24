package repository;


import entity.Address;
import hibernatConfig.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AddressRepository {

    public List<Address> getAllAddress(){
        Session session = null;
        try {
            session = HibernateUtils.getInstance().openSession();

            Query<Address> query = session.createQuery("FROM Address ");

            return query.list();
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    public void createAddress(Address address){
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();

            session.save(address);
        }finally {
            if(session!= null){
                session.close();
            }

        }
    }

    public void updateAddress(short id ,String addressName){

        Session session = null;

        try {
            session =HibernateUtils.getInstance().openSession();
            session.beginTransaction();

            Address address = session.load(Address.class,id);

            address.setAddressName(addressName);

            session.update(address);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void deleteAddress(short id){
        Session session = null;

        try{
            session = HibernateUtils.getInstance().openSession();
            session.getTransaction();

            Address address = session.load(Address.class,id);

            session.delete(address);
            session.getTransaction().commit();

        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
