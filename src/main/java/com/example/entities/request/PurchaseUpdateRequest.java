package com.example.entities.request;

import com.example.entities.enumclass.statusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseUpdateRequest {
    private Long id;
    private Long employeeId;
    private Long supplierId;
    private statusEnum statusCode;
}
