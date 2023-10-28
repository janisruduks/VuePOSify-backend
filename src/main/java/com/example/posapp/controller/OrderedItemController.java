package com.example.posapp.controller;

import com.example.posapp.entity.OrderedItem;
import com.example.posapp.request.create.CreateOrderItemsRequest;
import com.example.posapp.service.OrderedItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ordered-items")
public class OrderedItemController {

    private final OrderedItemService service;

    public OrderedItemController(OrderedItemService service) {
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public List<OrderedItem> createOrderedItemsList(@RequestBody List<CreateOrderItemsRequest> request) {
        return service.saveOrderedItems(request);
    }

    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderedItem> getAllOrderItems(@PathVariable Long orderId) {
        return service.getAllOrderItems(orderId);
    }
}
