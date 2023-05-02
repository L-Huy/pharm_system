package com.example.services;

import com.example.entities.OrderInvoice;

import java.util.List;

public interface OrderInvoiceService {
    OrderInvoice add(OrderInvoice orderInvoice);
    OrderInvoice update(OrderInvoice orderInvoice);
    boolean deleteById(Long id);
    List<OrderInvoice> findAll();
}
