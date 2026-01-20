package com.example.masmenu.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.masmenu.model.entity.Order;
import com.example.masmenu.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/kitchen")
@RequiredArgsConstructor
public class KitchenController {

  private final OrderService orderService;

  @PreAuthorize("hasRole('COCINA')")
  @GetMapping("/orders")
  public List<Order> getOrdersForKitchen() {
    return orderService.getActiveOrders();
  }
}
