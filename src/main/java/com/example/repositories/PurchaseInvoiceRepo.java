package com.example.repositories;

import com.example.entities.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseInvoiceRepo extends JpaRepository<PurchaseInvoice, Long> {
}
