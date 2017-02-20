package com.emusicstore.service;

import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by samrat on 2/19/17.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);


}
