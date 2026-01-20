package com.example.masmenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.masmenu.model.entity.Dish;

import java.util.List;

public interface DishRepository
    extends JpaRepository<Dish, Long> {

  List<Dish> findByAvailableTrue();

  List<Dish> findByCategoryId(Long categoryId);
}
