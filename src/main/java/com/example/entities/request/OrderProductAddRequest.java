package com.example.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductAddRequest {
    private Long orderId;
    private Long stockId;
    private int qty;
    private double salePrice;

}
