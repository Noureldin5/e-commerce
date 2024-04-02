package com.example.eCommerce.service.cart.Impl;

import com.example.eCommerce.dto.Cart.CartRequest;
import com.example.eCommerce.dto.Cart.CartResponse;
import com.example.eCommerce.entities.Cart;
import com.example.eCommerce.entities.Order;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.mapper.product.ProductMapper;
import com.example.eCommerce.repositories.*;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    private final AuthService authService;
    private UserRepository userRepository;
    private TypeRepository typeRepository;
    private CategoryRepository categoryRepository;

    private ProductRepository productRepository;



    @Override
    public void add(CartRequest request, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = new Cart();
        cart.setProducts((List<Product>) productRepository.findById(request.getProductId()).get());productRepository.findById(request.getProductId());
        cart.setUser(userRepository.findByEmail(user.getUsername()));
        cartRepository.save(cart);

    }

    @Override
    public void update(CartRequest request, String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = new Cart();
        cart.setProducts((List<Product>) productRepository.findById(request.getProductId()).get());
        cart.setUser(userRepository.findByEmail(user.getUsername()));
        cartRepository.save(cart);

    }

    @Override
    public void buy(String token) {
        User user = authService.getUsernameFromToken(token);
        Cart cart = new Cart();
        cart.setProducts((List<Product>) productRepository.findById(get(token).getProducts().get(0).getId()).get());

        cart.setUser(userRepository.findByEmail(user.getUsername()));
        cartRepository.save(cart);

        user.setCart(cart);
        userRepository.save(user);

        user.setCart(null);
        userRepository.save(user);

        cartRepository.delete(cart);

        user.setCart(cart);
        userRepository.save(user);

        user.setCart(null);
        userRepository.save(user);

    }

    @Override
    public CartResponse get(String token) {

        User user = authService.getUsernameFromToken(token);
        Order cart = user.getCart();
        CartResponse cartResponse = new CartResponse();
        cartResponse.setProducts(cart.getProducts());
        return cartResponse;

    }

    @Override
    public void delete(CartRequest request, String token) {

        User user = authService.getUsernameFromToken(token);
        Cart cart = new Cart();
        cart.setProducts((List<Product>) productRepository.findById(request.getProductId()).get());
        cart.setUser(userRepository.findByEmail(user.getUsername()));
        cartRepository.delete(cart);
    }
}
