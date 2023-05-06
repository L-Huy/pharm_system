package com.example.services.impl;

import com.example.entities.OrderInvoice;
import com.example.entities.projections.OrderInvoiceProjection;
import com.example.entities.projections.OrderProjection;
import com.example.entities.response.pagination;
import com.example.repositories.OrderInvoiceRepo;
import com.example.services.OrderInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public List<OrderInvoiceProjection> findOrderInvoiceProjectionAll(pagination p) {
        Page<OrderInvoiceProjection> ord = orderInvoiceRepo.findAllOrderInvoiceProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(ord.getTotalElements());
        return ord.getContent() ;
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
        oi.setId(orderInvoice.getId());
        oi.setOrder(orderInvoice.getOrder());
        oi.setPaymentType(orderInvoice.getPaymentType());
        oi.setTotal_paid(orderInvoice.getTotal_paid());
        oi.setStatus(orderInvoice.getStatus());
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
    public OrderInvoice findById(Long id) {
        return this.orderInvoiceRepo.findById(id).orElse(null);
    }

}
