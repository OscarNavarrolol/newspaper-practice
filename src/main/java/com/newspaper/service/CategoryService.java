package com.newspaper.service;

import com.newspaper.entity.Category;
import com.newspaper.entity.User;

import java.util.List;

public interface CategoryService {
    public List<Category> getAll();

    public Category saveCategory(Category category);

    public Category getCategoryById(Long id);

    public Category updateCategory(Long id, Category category);

    public void deleteCategory(long id);
}
