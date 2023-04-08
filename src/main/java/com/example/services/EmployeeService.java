package com.example.services;

import com.example.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee add(Employee employee);
    Employee update(Employee employee);
    boolean deleteById(Long id);
    Employee findById(Long id);
}
