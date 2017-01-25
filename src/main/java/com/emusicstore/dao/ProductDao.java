package com.emusicstore.dao;

import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by samrat on 1/3/17.
 */
public interface ProductDao {

    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProduct(Long id);


}
