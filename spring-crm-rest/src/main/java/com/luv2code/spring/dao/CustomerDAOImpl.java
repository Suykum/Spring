package com.luv2code.spring.dao;

import com.luv2code.spring.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // required
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory; // bean name in spring config file

    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result
        List<Customer> customers = query.getResultList();

        // return the result
        return customers;
    }

    public void saveCustom(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    public void deleteCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();

        // delete object with primary key
        Customer customer = session.get(Customer.class, theId);
        session.delete(customer);
        /*Query query = session.createQuery("delete from Customer where id = :customerId");
                query.setParameter("customerId", theId);*/

    }


}
