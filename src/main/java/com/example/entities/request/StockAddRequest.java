package com.example.entities.request;

import com.example.entities.enumclass.statusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockAddRequest {
    private Long productId;
    private Long uomId;
    private int qty_on_hand;
    private statusEnum statusCode;
}
