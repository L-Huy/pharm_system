package com.example.services;

import com.example.entities.Stock;

import java.util.List;

public interface StockService {
    Stock add(Stock stock);
    Stock update(Stock stock);
    boolean deleteById(Long id);
    List<Stock> findAll();
    Stock findById(Long id);
}
