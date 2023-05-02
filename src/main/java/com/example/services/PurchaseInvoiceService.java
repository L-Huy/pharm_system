package com.example.services;

import com.example.entities.PurchaseInvoice;

import java.util.List;

public interface PurchaseInvoiceService {
    PurchaseInvoice add(PurchaseInvoice purchaseInvoice);
    PurchaseInvoice update(PurchaseInvoice purchaseInvoice);
    boolean deleteById(Long id);
    List<PurchaseInvoice> findAll();
}
