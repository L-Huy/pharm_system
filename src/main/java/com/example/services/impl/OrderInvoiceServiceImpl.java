package com.example.services.impl;

import com.example.entities.OrderInvoice;
import com.example.repositories.OrderInvoiceRepo;
import com.example.services.OrderInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInvoiceServiceImpl implements OrderInvoiceService {
    private OrderInvoiceRepo orderInvoiceRepo;
    @Autowired
    public OrderInvoiceServiceImpl(OrderInvoiceRepo orderInvoiceRepo){
        this.orderInvoiceRepo = orderInvoiceRepo;
    }


    @Override
    public OrderInvoice add(OrderInvoice orderInvoice) {
        orderInvoice.setCreatedBy("Admin");
        return this.orderInvoiceRepo.save(orderInvoice);
    }

    @Override
    public OrderInvoice update(OrderInvoice orderInvoice) {
        OrderInvoice oi = this.orderInvoiceRepo.findById(orderInvoice.getId()).orElse(null);
        if (oi == null) {
            return null;
        }
        oi.setUpdatedBy("Admin");
        oi.setOrder(orderInvoice.getOrder());
        oi.setPaymentType(orderInvoice.getPaymentType());
        oi.setTotal_paid(orderInvoice.getTotal_paid());
        return this.orderInvoiceRepo.save(oi);
    }

    @Override
    public boolean deleteById(Long id) {
        OrderInvoice orderInvoice = this.orderInvoiceRepo.findById(id).orElse(null);
        if (orderInvoice == null){
            return false;
        }
        this.orderInvoiceRepo.deleteById(id);
        return true;
    }

    @Override
    public List<OrderInvoice> findAll() {
        return this.orderInvoiceRepo.findAll();
    }
}
