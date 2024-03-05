package com.example.eCommerce.service.cart.Impl;

import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.service.cart.CartService;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CartServiceImpl implements CartService {
    @Override
    public Cart getCart(User user) {
        return null;
    }

    @Override
    public void delete(String itemId, User user) {

    }

    @Override
    public void checkout(User user) {

    }

    @Override
    public void mergeLocalCart(Collection<Product> productInOrders, User user) {

    }
}
