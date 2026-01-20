package com.example.masmenu.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrderItem {

  @Id
  @GeneratedValue
  private Long id;

  // 🔒 Datos congelados del platillo
  private Long dishId;
  private String dishName;
  private Double price;

  private Integer quantity;
  private Double subtotal;
}
