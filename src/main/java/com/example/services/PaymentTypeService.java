package com.example.services;

import com.example.entities.PaymentType;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.PaymentProjection;
import com.example.entities.projections.UomProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface PaymentTypeService {
    List<PaymentProjection> findPaymentProjectionAll(pagination p);
    PaymentType add(PaymentType paymentType);
    PaymentType update(PaymentType paymentType);
    boolean deleteById(Long id);
    PaymentType findById(Long id);
}
