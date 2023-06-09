package com.example.repositories;

import com.example.entities.Purchase;
import com.example.entities.projections.PurchaseProjection;
import com.example.entities.projections.StockProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
    Page<PurchaseProjection> findAllPurchaseProjectionBy(Pageable pageable);
}
