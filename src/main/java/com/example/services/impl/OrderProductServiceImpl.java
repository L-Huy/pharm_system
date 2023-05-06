package com.example.services.impl;

import com.example.entities.OrderProduct;
import com.example.entities.projections.OrderProductProjection;
import com.example.entities.projections.OrderProjection;
import com.example.entities.response.pagination;
import com.example.repositories.OrderProductRepo;
import com.example.services.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {
    private OrderProductRepo orderProductRepo;
    @Autowired
    public OrderProductServiceImpl(OrderProductRepo orderProductRepo){
        this.orderProductRepo = orderProductRepo;
    }


    @Override
    public List<OrderProductProjection> findOrderProductProjectionAll(pagination p) {
        Page<OrderProductProjection> ord = orderProductRepo.findAllOrderProductProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(ord.getTotalElements());
        return ord.getContent() ;
    }
    @Override
    public OrderProduct add(OrderProduct orderProduct) {
        orderProduct.setCreatedBy("Admin");
        return this.orderProductRepo.save(orderProduct);
    }

    @Override
    public OrderProduct update(OrderProduct orderProduct) {
        OrderProduct op = this.orderProductRepo.findById(orderProduct.getId()).orElse(null);
        if (op == null) {
            return null;
        }
        op.setUpdatedBy("Admin");
        op.setId(orderProduct.getId());
        op.setOrder(orderProduct.getOrder());
        op.setStock(orderProduct.getStock());
        op.setQty(orderProduct.getQty());
        op.setSale_price(orderProduct.getSale_price());
        op.setStatus(orderProduct.getStatus());
        return this.orderProductRepo.save(op);
    }

    @Override
    public boolean deleteById(Long id) {
        OrderProduct orderProduct = this.orderProductRepo.findById(id).orElse(null);
        if (orderProduct == null){
            return false;
        }
        this.orderProductRepo.deleteById(id);
        return true;
    }

    @Override
    public OrderProduct findById(Long id) {
        return this.orderProductRepo.findById(id).orElse(null);
    }

}
