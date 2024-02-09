package com.example.eCommerce.service.product;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.dto.Product.ProductResponse;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequest productRequest, String token);

    void deleteProduct(Long id);

    ProductResponse getById(Long id);

    void updateProduct(Long id, ProductRequest productRequest);

    List<ProductResponse> getAll();
}
