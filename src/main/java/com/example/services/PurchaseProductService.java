package com.example.services;

import com.example.entities.PurchaseProduct;

import java.util.List;

public interface PurchaseProductService {
    PurchaseProduct add(PurchaseProduct purchaseProduct);
    PurchaseProduct update(PurchaseProduct purchaseProduct);
    boolean deleteById(Long id);
    List<PurchaseProduct> findAll();
}
