package com.example.entities.request;

import com.example.entities.OrderProduct;
import com.example.entities.enumclass.statusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderAddRequest {
    private Long employeeId;
    private Long customerId;

//    private List<OrderProductReq> orderProductReqs;
}
