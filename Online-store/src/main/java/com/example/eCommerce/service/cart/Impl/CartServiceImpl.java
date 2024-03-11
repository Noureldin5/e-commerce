package com.example.eCommerce.service.cart.Impl;

import com.example.eCommerce.dto.Cart.CartRequest;
import com.example.eCommerce.dto.Cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.service.cart.CartService;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CartServiceImpl implements CartService
{



    @Override
    public void add(CartRequest request, String token) {

    }

    @Override
    public void update(CartRequest request, String token) {

    }

    @Override
    public void buy(String token) {

    }

    @Override
    public CartResponse get(String token) {
        return null;
    }

    @Override
    public void delete(CartRequest request, String token) {

    }
}
