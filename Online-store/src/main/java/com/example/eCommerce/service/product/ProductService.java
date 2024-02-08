package com.example.eCommerce.service.product;

import com.example.eCommerce.dto.Product.ProductRequest;

public interface ProductService {

    void addProduct(ProductRequest productRequest, String token);
}
