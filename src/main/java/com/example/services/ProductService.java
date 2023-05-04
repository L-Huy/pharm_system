package com.example.services;

import com.example.entities.Product;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.ProductProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface ProductService {
    List<ProductProjection> findProductProjectionAll(pagination p);
    Product add(Product product);
    Product update(Product product);
    boolean deleteById(Long id);
    Product findById(Long id);
}
