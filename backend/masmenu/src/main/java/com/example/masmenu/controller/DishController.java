package com.example.masmenu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.masmenu.model.entity.Dish;
import com.example.masmenu.service.MenuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/dishes")
@RequiredArgsConstructor
public class DishController {

  private final MenuService menuService;

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping
  public Dish create(@RequestBody Dish dish) {
    return menuService.createDish(dish);
  }

  @PutMapping("/{id}/price")
  public Dish updatePrice(
      @PathVariable Long id,
      @RequestParam double price) {

    return menuService.updatePrice(id, price);
  }

  @PutMapping("/{id}/availability")
  public Dish updateAvailability(
      @PathVariable Long id,
      @RequestParam boolean available) {

    return menuService.setAvailability(id, available);
  }
}
