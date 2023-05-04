package com.example.repositories;

import com.example.entities.PaymentType;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.PaymentProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepo extends JpaRepository<PaymentType, Long> {
    Page<PaymentProjection> findAllPaymentProjectionBy(Pageable pageable);
}
