package com.example.eCommerce.mapper.category;

import com.example.eCommerce.dto.Category.CategoryResponse;
import com.example.eCommerce.entities.Category;

import java.util.List;

public interface CategoryMapper {
    List<CategoryResponse> toDtoS(List<Category> all);
}
