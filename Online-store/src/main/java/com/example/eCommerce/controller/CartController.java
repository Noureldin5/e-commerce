package com.example.eCommerce.controller;

import com.example.eCommerce.dto.Cart.CartRequest;
import com.example.eCommerce.dto.Cart.CartResponse;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.service.cart.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final ProductRepository productRepository;

    private final CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody CartRequest request, @RequestHeader("Authorization") String token){
        cartService.add(request, token);
        return productRepository.findById(request.getProductId()) + " added to your cart!";
    }

    @PutMapping("/update")
    public String updateCart(@RequestBody CartRequest request, @RequestHeader("Authorization") String token){
        cartService.update(request, token);
        return "Quantity updated successfully!";
    }

    @DeleteMapping("/delete")
    public String deleteCart(@RequestBody CartRequest request, @RequestHeader("Authorization") String token){
        cartService.delete(request, token);
        return "Product deleted successfully!";
    }

    @GetMapping("/show")
    public CartResponse getCart(@RequestHeader("Authorization") String token){
        return cartService.get(token);
    }

    @PostMapping("/buy")
    public String buyCart(@RequestHeader("Authorization") String token){
        cartService.buy(token);
        return "Products bought succesfully!";
    }

}
