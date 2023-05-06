package com.example.entities.request;

import com.example.entities.enumclass.statusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseProductUpdateRequest {
    private Long id;
    private Long purchaseId;
    private Long stockId;
    private int qty;
    private double costPrice;
    private statusEnum statusCode;
}
