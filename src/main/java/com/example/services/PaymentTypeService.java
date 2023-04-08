package com.example.services;

import com.example.entities.PaymentType;

import java.util.List;

public interface PaymentTypeService {
    List<PaymentType> findAll();
    PaymentType add(PaymentType paymentType);
    PaymentType update(PaymentType paymentType);
    boolean deleteById(Long id);
    PaymentType findById(Long id);
}
