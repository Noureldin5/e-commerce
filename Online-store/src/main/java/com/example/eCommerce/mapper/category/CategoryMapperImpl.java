package com.example.eCommerce.mapper.category;

import com.example.eCommerce.dto.Category.CategoryResponse;
import com.example.eCommerce.entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapperImpl implements CategoryMapper{
    @Override
    public List<CategoryResponse> toDtoS(List<Category> all) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category: all){
            categoryResponses.add(toDto(category));
        }
        return categoryResponses;
    }

    private CategoryResponse toDto(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getCategoryName());
        return categoryResponse;
    }
}
