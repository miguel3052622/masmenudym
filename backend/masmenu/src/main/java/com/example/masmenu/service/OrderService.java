package com.example.masmenu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.masmenu.model.entity.Dish;
import com.example.masmenu.model.entity.Order;
import com.example.masmenu.model.entity.OrderItem;
import com.example.masmenu.model.entity.Sale;
import com.example.masmenu.model.enums.OrderStatus;
import com.example.masmenu.repository.DishRepository;
import com.example.masmenu.repository.OrderRepository;
import com.example.masmenu.repository.SaleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

  private final OrderRepository orderRepository;
  private final DishRepository dishRepository;
  private final SaleRepository saleRepository;

  /* ---------- CREATE ORDER ---------- */

  public Order createOrder(Order order) {

    if (order.getItems() == null || order.getItems().isEmpty()) {
      throw new RuntimeException("Order must have at least one item");
    }

    order.setStatus(OrderStatus.CREATED);
    order.setCreatedAt(LocalDateTime.now());

    double total = 0;

    for (OrderItem item : order.getItems()) {

      if (item.getQuantity() == null || item.getQuantity() <= 0) {
        throw new RuntimeException("Invalid quantity");
      }

      Dish dish = dishRepository.findById(item.getDishId())
          .orElseThrow(() -> new RuntimeException("Dish not found"));

      if (!dish.isAvailable()) {
        throw new RuntimeException("Dish not available: " + dish.getName());
      }

      // 🔒 CONGELAR DATOS
      item.setDishName(dish.getName());
      item.setPrice(dish.getPrice());
      item.setSubtotal(dish.getPrice() * item.getQuantity());

      total += item.getSubtotal();
    }

    order.setTotal(total);
    return orderRepository.save(order);
  }

  /* ---------- UPDATE STATUS ---------- */

  public Order updateStatus(Long orderId, OrderStatus newStatus) {

    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Order not found"));

    OrderStatus current = order.getStatus();

    if (!isValidTransition(current, newStatus)) {
      throw new RuntimeException(
          "Invalid status transition: " + current + " -> " + newStatus);
    }

    order.setStatus(newStatus);

    if (newStatus == OrderStatus.CLOSED) {
      createSale(order);
    }

    return orderRepository.save(order);
  }

  /* ---------- SALE ---------- */

  private void createSale(Order order) {
    Sale sale = new Sale();
    sale.setOrderId(order.getId());
    sale.setTotal(order.getTotal());
    sale.setDate(LocalDateTime.now());

    saleRepository.save(sale);
  }

  /* ---------- VALIDATION ---------- */

  private boolean isValidTransition(
      OrderStatus current,
      OrderStatus next) {

    if (current == OrderStatus.CREATED) {
      return next == OrderStatus.IN_KITCHEN;
    }

    if (current == OrderStatus.IN_KITCHEN) {
      return next == OrderStatus.READY;
    }

    if (current == OrderStatus.READY) {
      return next == OrderStatus.CLOSED;
    }

    return false;
  }

  /* ---------- QUERIES ---------- */

  public List<Order> getActiveOrders() {
    return orderRepository.findByStatusNot(OrderStatus.CLOSED);
  }
}
