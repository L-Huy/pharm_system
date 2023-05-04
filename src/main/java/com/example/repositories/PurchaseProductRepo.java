package com.example.repositories;

import com.example.entities.PurchaseProduct;
import com.example.entities.projections.PurchaseProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseProductRepo extends JpaRepository<PurchaseProduct, Long> {
    Page<PurchaseProductProjection> findAllPurchaseProductProjectionBy(Pageable pageable);
}
