package com.example.services;

import com.example.entities.Supplier;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.SupplierProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface SupplierService {
    List<SupplierProjection> findSupplierProjectionAll(pagination p);
    Supplier add(Supplier supplier);
    Supplier update(Supplier supplier);
    boolean deleteById(Long id);
    Supplier findById(Long id);
}
