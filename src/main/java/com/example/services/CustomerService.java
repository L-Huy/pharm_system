package com.example.services;

import com.example.entities.Customer;
import com.example.entities.projections.CustomerProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface CustomerService {
    List<CustomerProjection> findCustomerProjectionAll(pagination p);
    Customer add(Customer customer);
    Customer update(Customer customer);
    boolean deleteById(Long id);
    Customer findById(Long id);
}
