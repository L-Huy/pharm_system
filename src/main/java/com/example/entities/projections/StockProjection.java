package com.example.entities.projections;

import com.example.entities.enumclass.statusEnum;

import java.util.List;

public interface StockProjection {
    Long getId();
    Long getQty_on_hand();
    List<PurchaseProductProjection> getPurchaseProductlist();
    List<OrderProductProjection> getOrderProductList();
}
