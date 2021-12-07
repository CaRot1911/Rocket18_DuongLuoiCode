package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.Filter;
import com.vti.utils.Paging;
import com.vti.utils.Sort;
import com.vti.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository{
    @Override
    public List<Department> getAllDepartment(Filter filter, Sort sort, Paging paging,String search) {
        Session session = null;
        try{
            session = HibernateUtils.getInstance().openSession();


            Criteria criteria = session.createCriteria(Department.class);

//            Search
            if(!StringUtils.isEmpty(search)){
                Criterion searchByName = Restrictions.ilike("departmentName","%" + search + "%");
//                Criterion searchByID = Restrictions.ilike("departmentID",search);
//
//                criteria.add(Restrictions.or(searchByName,searchByID));
                criteria.add(searchByName);
            }
//            Filter
//            MinMember
            if(filter.getMinMember() != null){
                criteria.add(Restrictions.gt("totalMember",filter.getMinMember().shortValue()));
            }
//            MaxMember
            if(filter.getMinMember() != null){
                criteria.add(Restrictions.lt("totalMember",filter.getMaxMember().shortValue()));
            }

//            Sort
            criteria.addOrder(sort.getTypeSort().equals("ASC")?Order.asc(sort.getNameSort()):Order.desc(sort.getNameSort()));

//            Paging
            int offset =  ((paging.getPage()-1)* paging.getSize());
            int limit = paging.getSize();

            criteria.setFirstResult(offset);
            criteria.setMaxResults(limit);

            return criteria.list();


        }finally {
            if(session != null){
                session.close();
            }
        }
    }
    
}
