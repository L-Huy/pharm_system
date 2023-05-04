package com.example.services;

import com.example.entities.Stock;
import com.example.entities.projections.StockProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface StockService {
    List<StockProjection> findStockProjectionAll(pagination p);
    Stock add(Stock stock);
    Stock update(Stock stock);
    boolean deleteById(Long id);
    Stock findById(Long id);
}
