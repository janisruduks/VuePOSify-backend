package com.example.posapp.repository;

import com.example.posapp.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<Table, Long> {
    List<Table> getAllByUserId(Long userId);
}
