package com.example.posapp.controller;

import com.example.posapp.entity.Order;
import com.example.posapp.service.OrderService;
import com.example.posapp.service.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService service;
    private final TableService tableService;

    public OrderController(OrderService service, TableService tableService) {
        this.service = service;
        this.tableService = tableService;
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Long tableId, @PathVariable Long userId) {
        Order order = service.createOrder(tableId, userId);
        tableService.attachOrderToTable(tableId, order);
        return order;
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders(@PathVariable Long userId) {
        return service.getAllOrders(userId);
    }

}