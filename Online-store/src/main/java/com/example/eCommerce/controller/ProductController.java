package com.example.eCommerce.controller;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductRequest productRequest, @RequestHeader("Authorization") String token){
        productService.addProduct(productRequest, token);
    }
}
