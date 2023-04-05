package com.example.services;

import com.example.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> selectAll();
    String selectById (long id);
    Customer Add(Customer customer);
}
