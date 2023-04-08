package com.example.services;

import com.example.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer add(Customer customer);
    Customer update(Customer customer);
    boolean deleteById(Long id);
    Customer findById(Long id);
}
