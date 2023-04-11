package com.example.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockUpdateRequest {
    private Long id;
    private Long productId;
    private Long uomId;
    private int qty_on_hand;
}
