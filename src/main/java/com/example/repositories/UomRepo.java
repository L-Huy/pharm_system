package com.example.repositories;

import com.example.entities.Uom;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.UomProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UomRepo extends JpaRepository<Uom, Long> {
    Page<UomProjection> findAllUomProjectionBy(Pageable pageable);
}
