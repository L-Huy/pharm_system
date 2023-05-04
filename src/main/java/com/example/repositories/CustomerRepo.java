package com.example.repositories;

import com.example.entities.Customer;
import com.example.entities.projections.CustomerProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Page<CustomerProjection> findAllCustomerProjectionBy(Pageable pageable);
}
