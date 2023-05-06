package com.example.entities.request;

import com.example.entities.enumclass.statusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseInvoiceAddRequest {
    private Long purchaseId;
    private Long paymentTypeId;
    private double totalPaid;
    private statusEnum statusCode;
}
