package com.example.eCommerce.service.category;

import com.example.eCommerce.dto.Category.CategoryResponse;

import java.util.List;

public interface CategoryService  {
    void addCategory(String name, String token);

    List<CategoryResponse> getAll();
}
