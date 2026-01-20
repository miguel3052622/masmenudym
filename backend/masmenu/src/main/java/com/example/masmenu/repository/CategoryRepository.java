package com.example.masmenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.masmenu.model.entity.Category;

public interface CategoryRepository
    extends JpaRepository<Category, Long> {
}
