package com.example.masmenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.masmenu.model.entity.Order;
import com.example.masmenu.model.enums.OrderStatus;

public interface OrderRepository
    extends JpaRepository<Order, Long> {

  // Órdenes que NO estén cerradas (para cocina y meseros)
  List<Order> findByStatusNot(OrderStatus status);
}
