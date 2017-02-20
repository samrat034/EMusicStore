package com.emusicstore.dao.Impl;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;


/**
 * Created by samrat on 1/3/17.
 */

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getProductList() {
        Session session= sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Product");
        List<Product> productList= query.getResultList();
        session.flush();
        return productList;
    }

    public Product getProductById(int id) {
        Session session=sessionFactory.getCurrentSession();
        Product product=session.get(Product.class, id);
        session.flush();
        return product;
    }

    public void addProduct(Product product) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();

    }

    public void editProduct(Product product) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();

    }

    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();

    }
}
