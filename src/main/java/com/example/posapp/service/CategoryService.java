package com.example.posapp.service;

import com.example.posapp.entity.Category;
import com.example.posapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category getCategoryById(Long categoryId) {
        return repository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found "));
    }

    public Category addCategory(String name, Long userId) {
        return repository.save(Category.builder()
                .name(name)
                .userId(userId)
                .build()
        );
    }

    public List<Category> getAllUserCategories(Long userId) {
        return repository.getAllByUserId(userId);
    }

    public void deleteCategory(Long categoryId) {
        repository.deleteById(categoryId);
    }
}