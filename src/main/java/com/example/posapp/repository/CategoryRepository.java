package com.example.posapp.repository;

import com.example.posapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> getAllByUserId(Long userId);
}
