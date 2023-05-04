package com.example.repositories;

import com.example.entities.Stock;
import com.example.entities.projections.ProductProjection;
import com.example.entities.projections.StockProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long> {
    Page<StockProjection> findAllStockProjectionBy(Pageable pageable);
}
