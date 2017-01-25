package com.emusicstore.dao.Impl;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by samrat on 1/3/17.
 */

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(Product product){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }


    public Product getProductById(Long id) {
        Session session=sessionFactory.getCurrentSession();
        Product product= session.get(Product.class, id);
        session.flush();
        return product;
    }

    public List<Product> getAllProducts() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Product");
        List<Product> products=query.list();
        session.flush();
        return products;
    }

    public void deleteProduct(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();
    }
}
