package com.example.services.impl;

import com.example.entities.PaymentType;
import com.example.repositories.PaymentTypeRepo;
import com.example.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {
    private PaymentTypeRepo paymentTypeRepo;
    @Autowired
    public PaymentTypeServiceImpl(PaymentTypeRepo paymentTypeRepo){
        this.paymentTypeRepo = paymentTypeRepo;
    }

    @Override
    public List<PaymentType> findAll() {
        return this.paymentTypeRepo.findAll();
    }

    @Override
    public PaymentType add(PaymentType paymentType) {
        return this.paymentTypeRepo.save(paymentType);
    }

    @Override
    public PaymentType update(PaymentType paymentType) {
        PaymentType pt = this.paymentTypeRepo.findById(paymentType.getId()).orElse(null);
        if (pt == null) {
            return null;
        }
        pt.setUpdatedBy("Admin");
        pt.setPayment_type(paymentType.getPayment_type());
        return this.paymentTypeRepo.save(pt);
    }

    @Override
    public boolean deleteById(Long id) {
        PaymentType paymentType = this.paymentTypeRepo.findById(id).orElse(null);
        if (paymentType == null) {
            return false;
        }
        this.paymentTypeRepo.deleteById(id);
        return true;
    }

    @Override
    public PaymentType findById(Long id) {
        return this.paymentTypeRepo.findById(id).orElse(null);
    }
}
