package com.example.controller;

import com.example.entities.PaymentType;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.PaymentProjection;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/paymentType")
public class PaymentTypeController {
    private PaymentTypeService paymentTypeService;
    @Autowired
    public PaymentTypeController(
            PaymentTypeService paymentTypeService
    ){
        this.paymentTypeService = paymentTypeService;
    }

    @PostMapping("/create")
    public ApiResponse add(@RequestBody PaymentType paymentType){
        paymentType.setPayment_type(paymentType.getPayment_type());
        this.paymentTypeService.add(paymentType);
        return new ApiResponse<>(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage());
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody PaymentType paymentType){
        paymentType.setId(paymentType.getId());
        paymentType.setPayment_type(paymentType.getPayment_type());
        paymentType.setStatus(paymentType.getStatus());
        this.paymentTypeService.update(paymentType);
        return new ApiResponse<>(
                ApiStatus.SUC_UPDATED.getCode(),
                ApiStatus.SUC_UPDATED.getMessage());
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.paymentTypeService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
    }

/*    @GetMapping("/find/{id}")
    public PaymentType findById(@PathVariable Long id){
        return this.paymentTypeService.findById(id);
    }*/

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<PaymentProjection> pay = this.paymentTypeService.findPaymentProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", pay);
        map.put("pagination", p);
        return map;
    }
}
