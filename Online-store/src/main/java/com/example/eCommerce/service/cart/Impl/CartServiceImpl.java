package com.example.eCommerce.service.cart.Impl;

import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.repositories.CartRepository;
import com.example.eCommerce.service.cart.CartService;
import com.example.eCommerce.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

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