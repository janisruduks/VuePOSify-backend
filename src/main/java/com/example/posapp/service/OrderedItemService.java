package com.example.posapp.service;

import com.example.posapp.entity.OrderedItem;
import com.example.posapp.repository.OrderedItemsRepository;
import com.example.posapp.request.create.CreateOrderItemsRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderedItemService {

    private final OrderService orderService;
    private final OrderedItemsRepository orderedItemsRepo;
    private final ItemService itemService;

    public OrderedItemService(OrderService orderService, OrderedItemsRepository orderedItemsRepo, ItemService itemService) {
        this.orderService = orderService;
        this.orderedItemsRepo = orderedItemsRepo;
        this.itemService = itemService;
    }

    public List<OrderedItem> saveOrderedItems(List<CreateOrderItemsRequest> request) {
        List<OrderedItem> orderedItems = request.stream().map(item -> OrderedItem.builder()
                        .userId(item.userId())
                        .order(orderService.getOrderById(item.orderId()))
                        .item(itemService.getItemById(item.itemId()))
                        .quantity(item.quantity())
                        .build()
                ).toList();
        orderService.updateOrderTotal(orderedItems.get(0).getOrder().getOrderId(), calculateOrderTotal(orderedItems));
        return orderedItemsRepo.saveAll(orderedItems);
    }

    private BigDecimal calculateOrderTotal(List<OrderedItem> orderedItems) {
        BigDecimal orderTotal = BigDecimal.ZERO;
        for (OrderedItem item : orderedItems) {
            BigDecimal itemTotal = item.getItem().getPrice().multiply(item.getQuantity());
            orderTotal = orderTotal.add(itemTotal);
        }
        return orderTotal;
    }

    public List<OrderedItem> getAllOrderItems(Long orderId) {
        return orderedItemsRepo.getAllByOrder(orderService.getOrderById(orderId));
    }
}
