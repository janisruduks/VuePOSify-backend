package com.example.posapp.service;

import com.example.posapp.entity.Order;
import com.example.posapp.entity.OrderStatus;
import com.example.posapp.entity.Table;
import com.example.posapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final TableService tableService;

    public OrderService(OrderRepository orderRepo, TableService tableService) {
        this.orderRepo = orderRepo;
        this.tableService = tableService;
    }

    public List<Order> getAllOrders(Long userId) {
        return orderRepo.findAllByUserId(userId);
    }

    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("item not found"));
    }

    public Order createOrder(Long tableId, Long userId) {
        Table table = tableService.getTableById(tableId);
        Order order = Order.builder()
                .userId(userId)
                .timeOpen(LocalDateTime.now())
                .status(OrderStatus.ACTIVE)
                .table(table)
                .build();
        return orderRepo.save(order);
    }

    public void updateOrderTotal(Long orderId, BigDecimal orderTotal) {
        Order order = getOrderById(orderId);
        order.setOrderTotal(orderTotal);
        orderRepo.save(order);
    }
}
