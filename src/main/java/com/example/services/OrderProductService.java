package com.example.services;

import com.example.entities.OrderProduct;
import com.example.entities.projections.OrderProductProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface OrderProductService {
    List<OrderProductProjection> findOrderProductProjectionAll(pagination p);
    OrderProduct add(OrderProduct orderProduct);
    OrderProduct update(OrderProduct orderProduct);
    boolean deleteById(Long id);
    OrderProduct findById(Long id);
}
