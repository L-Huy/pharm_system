package com.example.repositories;

import com.example.entities.OrderInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInvoiceRepo extends JpaRepository<OrderInvoice, Long> {
}
