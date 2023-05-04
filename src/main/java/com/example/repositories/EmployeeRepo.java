package com.example.repositories;

import com.example.entities.Employee;
import com.example.entities.projections.CustomerProjection;
import com.example.entities.projections.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Page<EmployeeProjection> findAllEmployeeProjectionBy(Pageable pageable);
}
