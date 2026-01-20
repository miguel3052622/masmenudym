package com.example.masmenu.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.masmenu.model.entity.Order;
import com.example.masmenu.model.enums.OrderStatus;
import com.example.masmenu.service.OrderService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PreAuthorize("hasRole('MESERO')")
  @PostMapping
  public Order create(@RequestBody Order order) {
    return orderService.createOrder(order);
  }

  @PutMapping("/{id}/status")
  public Order updateStatus(
      @PathVariable Long id,
      @RequestParam OrderStatus status) {

    return orderService.updateStatus(id, status);
  }

  @GetMapping("/active")
  public List<Order> getActiveOrders() {
    return orderService.getActiveOrders();
  }
}
