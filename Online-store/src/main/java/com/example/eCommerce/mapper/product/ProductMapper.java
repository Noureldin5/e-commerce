package com.example.eCommerce.mapper.product;

import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;

import java.util.List;

public interface ProductMapper {
    ProductResponse toDto(Product product);

    List<ProductResponse> toDtoS(List<Product> all);
}
