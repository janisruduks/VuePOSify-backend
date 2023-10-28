package com.example.posapp.request.create;

import java.math.BigDecimal;

public record CreateOrderItemsRequest(Long orderId, Long itemId, Long userId, BigDecimal quantity) {
}