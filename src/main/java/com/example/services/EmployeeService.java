package com.example.services;

import com.example.entities.Employee;
import com.example.entities.projections.CustomerProjection;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface EmployeeService {
    List<EmployeeProjection> findEmployeeProjectionAll(pagination p);
    Employee add(Employee employee);
    Employee update(Employee employee);
    boolean deleteById(Long id);
    Employee findById(Long id);
}
