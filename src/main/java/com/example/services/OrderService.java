package com.example.services;

import com.example.entities.Order;
import com.example.entities.projections.OrderProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface OrderService {
    List<OrderProjection> findOrderProjectionAll(pagination p);
    Order add(Order order);
    Order update(Order order);
    boolean deleteById(Long id);
    Order findById(Long id);
}
