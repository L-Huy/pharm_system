package com.example.services;

import com.example.entities.Purchase;
import com.example.entities.PurchaseInvoice;
import com.example.entities.projections.PurchaseInvoiceProjection;
import com.example.entities.projections.PurchaseProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface PurchaseInvoiceService {
    List<PurchaseInvoiceProjection> findPurchaseInvoiceProjectionAll(pagination p);
    PurchaseInvoice add(PurchaseInvoice purchaseInvoice);
    PurchaseInvoice update(PurchaseInvoice purchaseInvoice);
    boolean deleteById(Long id);
    PurchaseInvoice findById(Long id);
}
