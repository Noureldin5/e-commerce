package com.example.eCommerce.service.cart;

import com.example.eCommerce.dto.Cart.CartRequest;
import com.example.eCommerce.dto.Cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.Product;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface CartService {

    void add(CartRequest request, String token);

    void update(CartRequest request, String token);

    void buy(String token);

    CartResponse get(String token);

    void delete(CartRequest request, String token);
}
