package com.example.masmenu.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.masmenu.model.enums.OrderStatus;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders") // "order" es palabra reservada en SQL
@Data
public class Order {

  @Id
  @GeneratedValue
  private Long id;

  private String tableNumber;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  private Double total;

  private LocalDateTime createdAt;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "order_id")
  private List<OrderItem> items;
}
