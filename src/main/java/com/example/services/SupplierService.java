package com.example.services;

import com.example.entities.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAll();
    Supplier add(Supplier supplier);
    Supplier update(Supplier supplier);
    boolean deleteById(Long id);
    Supplier findById(Long id);
}
