package com.example.eCommerce.service.cart;

import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.Product;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public interface CartService {
    Cart getCart(User user);


    void delete(String itemId, User user);

    void checkout(User user);

    void mergeLocalCart(Collection<Product> productInOrders, User user);
}
