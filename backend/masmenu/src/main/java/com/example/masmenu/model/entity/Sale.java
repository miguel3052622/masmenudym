package com.example.masmenu.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Sale {

  @Id
  @GeneratedValue
  private Long id;

  // 🔗 referencia a la orden cerrada
  private Long orderId;

  private Double total;

  private LocalDateTime date;
}
