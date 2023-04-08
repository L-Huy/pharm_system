package com.example.controller;

import com.example.entities.PaymentType;
import com.example.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentType")
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

    @GetMapping("/find/{id}")
    public PaymentType findById(@PathVariable Long id){
        return this.paymentTypeService.findById(id);
    }

    @GetMapping("/find")
    public List<PaymentType> findAll(){
        return this.paymentTypeService.findAll();
    }
}
