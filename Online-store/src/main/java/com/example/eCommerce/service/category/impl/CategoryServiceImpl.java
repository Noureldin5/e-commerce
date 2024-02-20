package com.example.eCommerce.service.category.impl;

import com.example.eCommerce.dto.Category.CategoryResponse;
import com.example.eCommerce.entities.Category;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.category.CategoryMapper;
import com.example.eCommerce.repositories.CategoryRepository;
import com.example.eCommerce.service.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;
    @Override
    public void addCategory(String name, String token) {
        if (categoryRepository.findByName(name).isPresent())
            throw new NotFoundException("type with name: "+name+" is already exist!", HttpStatus.BAD_REQUEST);
        Category category=new Category();
        category.setCategoryName(name);
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryResponse> getAll() {
        return categoryMapper.toDtoS(categoryRepository.findAll());
    }
}
