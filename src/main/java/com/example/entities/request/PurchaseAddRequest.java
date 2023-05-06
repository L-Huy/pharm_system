package com.example.entities.request;

import com.example.entities.enumclass.statusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseAddRequest {
    private Long employeeId;
    private Long supplierId;
    private statusEnum statusCode;
//    private List<PurchaseProductReq> purchaseProductReqs;

}
