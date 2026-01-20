package com.example.masmenu.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.masmenu.model.entity.Sale;
import com.example.masmenu.service.SaleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/sales")
@RequiredArgsConstructor
public class SaleController {

  private final SaleService saleService;

  @GetMapping
  public List<Sale> getSales(
      @RequestParam LocalDateTime start,
      @RequestParam LocalDateTime end) {

    return saleService.getSales(start, end);
  }
}
