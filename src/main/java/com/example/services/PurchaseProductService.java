package com.example.services;

import com.example.entities.PurchaseProduct;
import com.example.entities.projections.OrderProductProjection;
import com.example.entities.projections.PurchaseProductProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface PurchaseProductService {
    List<PurchaseProductProjection> findPurchaseProductProjectionAll(pagination p);
    PurchaseProduct add(PurchaseProduct purchaseProduct);
    PurchaseProduct update(PurchaseProduct purchaseProduct);
    boolean deleteById(Long id);
    PurchaseProduct findById(Long id);
}
