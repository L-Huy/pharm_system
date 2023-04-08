package com.example.repositories;

import com.example.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepo extends JpaRepository<PaymentType, Long> {

}
