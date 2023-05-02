package com.example.services;

import com.example.entities.OrderProduct;

import java.util.List;

public interface OrderProductService {
    OrderProduct add(OrderProduct orderProduct);
    OrderProduct update(OrderProduct orderProduct);
    boolean deleteById(Long id);
    List<OrderProduct> findAll();
}
