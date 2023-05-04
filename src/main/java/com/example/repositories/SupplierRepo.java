package com.example.repositories;

import com.example.entities.Supplier;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.SupplierProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Long> {
    Page<SupplierProjection> findAllSupplierProjectionBy(Pageable pageable);
}
