package com.example.services;

import com.example.entities.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase add(Purchase purchase);
    Purchase update(Purchase purchase);
    boolean deleteById(Long id);
    List<Purchase> findAll();
}
