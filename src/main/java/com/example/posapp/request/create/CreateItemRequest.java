package com.example.posapp.request.create;

import java.math.BigDecimal;

public record CreateItemRequest(
        String title,
        BigDecimal price,
        String description,
        String imageUrl,
        Long categoryId
) { }