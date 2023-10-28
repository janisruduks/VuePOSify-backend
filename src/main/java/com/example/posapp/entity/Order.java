package com.example.posapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@jakarta.persistence.Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "time_open")
    private LocalDateTime timeOpen;
    @Column(name = "time_closed")
    private LocalDateTime timeClosed;
    private BigDecimal orderTotal;
    private OrderStatus status;
    @Column(name = "user_id")
    private Long userId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "table_id")
    private Table table;
}