package com.example.masmenu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.masmenu.model.entity.Category;
import com.example.masmenu.service.MenuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final MenuService menuService;

  @GetMapping
  public List<Category> getAll() {
    return menuService.getCategories();
  }

  @PostMapping
  public Category create(@RequestBody Category category) {
    return menuService.createCategory(category);
  }

  @PutMapping("/{id}")
  public Category update(
      @PathVariable Long id,
      @RequestParam String name) {

    return menuService.updateCategory(id, name);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    menuService.deleteCategory(id);
  }
}
