package com.example.masmenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.masmenu.model.entity.Sale;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository
    extends JpaRepository<Sale, Long> {

  List<Sale> findByDateBetween(
      LocalDateTime start,
      LocalDateTime end
  );
}
