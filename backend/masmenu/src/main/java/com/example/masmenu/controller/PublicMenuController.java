package com.example.masmenu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.masmenu.model.entity.Dish;
import com.example.masmenu.repository.DishRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class PublicMenuController {

  private final DishRepository dishRepository;

  @GetMapping
  public List<Dish> getMenu() {
    return dishRepository.findByAvailableTrue();
  }
}
