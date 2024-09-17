package com.newspaper.service.impl;

import com.newspaper.entity.Category;
import com.newspaper.repository.CategoryRepository;
import com.newspaper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll() ;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category oldCategory = categoryRepository.findById(id).orElse(null);
        if (oldCategory != null){
            oldCategory.setNameCategory(category.getNameCategory());
            return categoryRepository.save(oldCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }
}
