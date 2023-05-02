package com.example.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInvoiceUpdateRequest {
    private Long orderId;
    private Long paymentTypeId;
    private double totalPaid;
}
