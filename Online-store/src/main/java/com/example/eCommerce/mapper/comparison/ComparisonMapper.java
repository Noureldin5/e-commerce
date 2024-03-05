package com.example.eCommerce.mapper.comparison;

import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;

public interface ComparisonMapper {
    ProductResponse toDto(Product product);
}
