package com.example.repositories;

import com.example.entities.Order;
import com.example.entities.projections.OrderProjection;
import com.example.entities.projections.StockProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Page<OrderProjection> findAllOrderProjectionBy(Pageable pageable);
}
