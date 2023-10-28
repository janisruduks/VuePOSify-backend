package com.example.posapp.repository;

import com.example.posapp.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> getAllByUserId(Long userId);
}