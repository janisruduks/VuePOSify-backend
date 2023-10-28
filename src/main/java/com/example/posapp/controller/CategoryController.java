package com.example.posapp.controller;

import com.example.posapp.entity.Category;
import com.example.posapp.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createUser(@PathVariable Long userId, @RequestBody String name) {
        return service.addCategory(name, userId);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllUserCategories(@PathVariable Long userId) {
        return service.getAllUserCategories(userId);
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Long categoryId) {
        service.deleteCategory(categoryId);
    }
}