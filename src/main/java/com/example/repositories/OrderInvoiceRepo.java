package com.example.repositories;

import com.example.entities.OrderInvoice;
import com.example.entities.projections.OrderInvoiceProjection;
import com.example.entities.projections.PurchaseInvoiceProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInvoiceRepo extends JpaRepository<OrderInvoice, Long> {
    Page<OrderInvoiceProjection> findAllOrderInvoiceProjectionBy(Pageable pageable);
}
