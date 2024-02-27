package com.example.eCommerce.service.product;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequest productRequest, String token);

    void deleteProduct(Long id);

    ProductResponse getById(Long id);

    void updateProduct(Long id, ProductRequest productRequest);

    List<ProductResponse> getAll();

    void update(String itemId, Integer quantity, User user);

    Product findOne(String productId);

    void buy(Long id, String token);

    List<ProductResponse> compare(Long fId, Long sId);
}
