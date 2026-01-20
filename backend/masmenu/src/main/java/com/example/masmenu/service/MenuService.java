package com.example.masmenu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.masmenu.model.entity.Category;
import com.example.masmenu.model.entity.Dish;
import com.example.masmenu.repository.CategoryRepository;
import com.example.masmenu.repository.DishRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuService {

  private final CategoryRepository categoryRepository;
  private final DishRepository dishRepository;

  /* ---------- CATEGORY ---------- */

  public List<Category> getCategories() {
    return categoryRepository.findAll();
  }

  public Category createCategory(Category category) {
    return categoryRepository.save(category);
  }

  public Category updateCategory(Long id, String name) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found"));

    category.setName(name);
    return categoryRepository.save(category);
  }

  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }

  /* ---------- DISH ---------- */

  public Dish createDish(Dish dish) {
    dish.setAvailable(true);
    return dishRepository.save(dish);
  }

  public Dish updatePrice(Long dishId, double newPrice) {
    if (newPrice <= 0) {
      throw new IllegalArgumentException("Price must be positive");
    }

    Dish dish = dishRepository.findById(dishId)
        .orElseThrow(() -> new RuntimeException("Dish not found"));

    dish.setPrice(newPrice);
    return dishRepository.save(dish);
  }

  public Dish setAvailability(Long dishId, boolean available) {
    Dish dish = dishRepository.findById(dishId)
        .orElseThrow(() -> new RuntimeException("Dish not found"));

    dish.setAvailable(available);
    return dishRepository.save(dish);
  }
}
