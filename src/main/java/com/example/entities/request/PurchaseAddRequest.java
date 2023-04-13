package com.example.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseAddRequest {
    private Long employeeId;
    private Long supplierId;
    private double totalPayment; //will delete later and replace by auto calculation
}
