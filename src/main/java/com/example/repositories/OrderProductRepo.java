package com.example.repositories;

import com.example.entities.OrderProduct;
import com.example.entities.projections.OrderProductProjection;
import com.example.entities.projections.OrderProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
    Page<OrderProductProjection> findAllOrderProductProjectionBy(Pageable pageable);
}
