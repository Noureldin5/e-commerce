package com.example.eCommerce.service.comparison;

import com.example.eCommerce.dto.Product.ProductResponse;

import java.util.List;

public interface ComparisonService {
    List<ProductResponse> compare(Long fId, Long sId);
}
