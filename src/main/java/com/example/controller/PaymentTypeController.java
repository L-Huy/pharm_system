package com.example.controller;

import com.example.entities.PaymentType;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.PaymentProjection;
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
    public PaymentType add(@RequestBody PaymentType paymentType){
        return this.paymentTypeService.add(paymentType);
    }

    @PutMapping("/update")
    public PaymentType update(@RequestBody PaymentType paymentType){
        return this.paymentTypeService.update(paymentType);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.paymentTypeService.deleteById(id);
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
