package com.example.services;

import com.example.entities.OrderInvoice;
import com.example.entities.projections.OrderInvoiceProjection;
import com.example.entities.projections.OrderProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface OrderInvoiceService {
    List<OrderInvoiceProjection> findOrderInvoiceProjectionAll(pagination p);
    OrderInvoice add(OrderInvoice orderInvoice);
    OrderInvoice update(OrderInvoice orderInvoice);
    boolean deleteById(Long id);
    OrderInvoice findById(Long id);
}
