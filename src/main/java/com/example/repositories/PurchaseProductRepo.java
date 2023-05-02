package com.example.repositories;

import com.example.entities.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseProductRepo extends JpaRepository<PurchaseProduct, Long> {
}
