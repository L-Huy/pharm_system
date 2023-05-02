package com.example.services;

import com.example.entities.Order;

import java.util.List;

public interface OrderService {
    Order add(Order order);
    Order update(Order order);
    boolean deleteById(Long id);
    List<Order> findAll();
    Order findById(Long id);
}
