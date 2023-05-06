package com.example.services.impl;

import com.example.entities.Order;
import com.example.entities.projections.OrderProjection;
import com.example.entities.projections.StockProjection;
import com.example.entities.response.pagination;
import com.example.repositories.OrderRepo;
import com.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepo  orderRepo;
    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }


    @Override
    public List<OrderProjection> findOrderProjectionAll(pagination p) {
        Page<OrderProjection> ord = orderRepo.findAllOrderProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(ord.getTotalElements());
        return ord.getContent() ;
    }

    @Override
    public Order add(Order order) {
        order.setCreatedBy("Admin");
        return this.orderRepo.save(order);
    }

    @Override
    public Order update(Order order) {
        Order o = this.orderRepo.findById(order.getId()).orElse(null);
        if (o == null) {
            return null;
        }
        o.setUpdatedBy("Admin");
        o.setId(order.getId());
        o.setEmployee(order.getEmployee());
        o.setCustomer(order.getCustomer());
        o.setStatus(order.getStatus());
        return this.orderRepo.save(o);
    }

    @Override
    public boolean deleteById(Long id) {
        Order order = this.orderRepo.findById(id).orElse(null);
        if (order == null){
            return false;
        }
        this.orderRepo.deleteById(id);
        return true;
    }

    @Override
    public Order findById(Long id) {
        return this.orderRepo.findById(id).orElse(null);
    }
}
