package com.example.entities.projections;


import java.util.List;

public interface PurchaseProjection {
    Long getId();
    List<PurchaseInvoiceProjection> getPurchaseInvoices();
    List<PurchaseProductProjection> getPurchaseProductList();
}
