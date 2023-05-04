package com.example.entities.projections;

import java.util.List;

public interface PaymentProjection {
    Long getId();
    String getPayment_type();
    List<OrderInvoiceProjection> getOrderInvoices();
    List<PurchaseInvoiceProjection> getPurchaseInvoices();
}
