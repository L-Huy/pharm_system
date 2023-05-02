package com.example.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseInvoiceUpdateRequest {
    private Long purchaseId;
    private Long paymentTypeId;
    private double totalPaid;
}