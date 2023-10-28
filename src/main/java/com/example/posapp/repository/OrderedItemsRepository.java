package com.example.posapp.repository;

import com.example.posapp.entity.Order;
import com.example.posapp.entity.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedItemsRepository extends JpaRepository<OrderedItem, Long> {
    List<OrderedItem> getAllByOrder(Order order);
}
