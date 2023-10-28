package com.example.posapp.service;

import com.example.posapp.entity.Order;
import com.example.posapp.entity.OrderStatus;
import com.example.posapp.entity.TableStatus;
import com.example.posapp.entity.Table;
import com.example.posapp.repository.OrderRepository;
import com.example.posapp.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TableService {

    private final TableRepository tableRepo;
    private final OrderRepository orderRepo;

    public TableService(TableRepository tableRepo, OrderRepository orderRepo) {
        this.tableRepo = tableRepo;
        this.orderRepo = orderRepo;
    }

    public Table getTableById(Long tableId) {
        return tableRepo.findById(tableId).orElseThrow(() -> new RuntimeException("Table not found"));
    }

    public Table saveTable(String name, Long userId) {
        return tableRepo.save(Table.builder()
                .status(TableStatus.AVAILABLE)
                .name(name)
                .userId(userId)
                .build()
        );
    }

    public void attachOrderToTable(Long tableId, Order order) {
        Table table = getTableById(tableId);
        table.setOrderId(order.getOrderId());
        tableRepo.save(table);
        updateTableStatus(tableId);
    }

    public List<Table> getAllUserTables(Long userId) {
        return tableRepo.getAllByUserId(userId);
    }

    public void updateTableStatus(Long tableId) {
        Table table = getTableById(tableId);
        Order order = orderRepo.findById(table.getOrderId()).orElseThrow(() -> new RuntimeException("Order not found"));
        table.setStatus(table.getStatus().getNextValue());
        if (table.getStatus() == TableStatus.AVAILABLE) {
            order.setTimeClosed(LocalDateTime.now());
            order.setStatus(OrderStatus.COMPLETED);
            orderRepo.save(order);
            table.setOrderId(null);
        }
        tableRepo.save(table);
    }

    public void deleteTableById(Long tableId) {
        tableRepo.deleteById(tableId);
    }
}
