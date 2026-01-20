package com.example.masmenu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.masmenu.model.entity.Sale;
import com.example.masmenu.repository.SaleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleService {

  private final SaleRepository saleRepository;

  public List<Sale> getSales(
      LocalDateTime start,
      LocalDateTime end) {

    return saleRepository.findByDateBetween(start, end);
  }
}
