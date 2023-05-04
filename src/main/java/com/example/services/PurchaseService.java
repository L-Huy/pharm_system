package com.example.services;

import com.example.entities.Purchase;
import com.example.entities.projections.PurchaseProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface PurchaseService {
    List<PurchaseProjection> findPurchaseProjectionAll(pagination p);
    Purchase add(Purchase purchase);
    Purchase update(Purchase purchase);
    boolean deleteById(Long id);
    Purchase findById(Long id);
}
