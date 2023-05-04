package com.example.repositories;

import com.example.entities.Product;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Page<ProductProjection> findAllProductProjectionBy(Pageable pageable);
}
