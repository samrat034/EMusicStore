package com.emusicstore.dao.Impl;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Authorities;
import com.emusicstore.model.Cart;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by samrat on 2/22/17.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();

    }

    @Override
    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);

    }

    @Override
    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.getResultList();
        return customerList;
    }

}
