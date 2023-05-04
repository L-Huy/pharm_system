package com.example.repositories;

import com.example.entities.PurchaseInvoice;
import com.example.entities.projections.PurchaseInvoiceProjection;
import com.example.entities.projections.PurchaseProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseInvoiceRepo extends JpaRepository<PurchaseInvoice, Long> {
    Page<PurchaseInvoiceProjection> findAllPurchaseInvoiceProjectionBy(Pageable pageable);
}
