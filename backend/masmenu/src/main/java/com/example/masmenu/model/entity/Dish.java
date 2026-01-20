package com.example.masmenu.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Dish {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private Double price;

  // ✅ ATRIBUTO booleano
  private boolean available;

  @ManyToOne
  private Category category;
}
