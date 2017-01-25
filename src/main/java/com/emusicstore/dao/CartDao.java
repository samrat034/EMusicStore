package com.emusicstore.dao;

import com.emusicstore.model.Cart;

/**
 * Created by samrat on 1/23/17.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete (String cartId);

}
