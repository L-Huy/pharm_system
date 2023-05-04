package com.example.entities.projections;

import com.example.entities.OrderInvoice;

import java.util.List;

public interface OrderProjection {
    Long getId();
    OrderInvoice getOrderInvoice();
    List<OrderProductProjection> getOrderProductList();
}
