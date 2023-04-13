package com.example.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseUpdateRequest {
    private String invoiceStat;
    private double totalPayment; //will delete later and replace by auto calculation
    private Long employeeId;
    private Long supplierId;
}
