package com.example.services.impl;

import com.example.entities.Order;
import com.example.repositories.OrderRepo;
import com.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
        o.setEmployee(order.getEmployee());
        o.setCustomer(order.getCustomer());
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
    public List<Order> findAll() {
        return this.orderRepo.findAll();
    }

    @Override
    public Order findById(Long id) {
        return this.orderRepo.findById(id).orElse(null);
    }
}
