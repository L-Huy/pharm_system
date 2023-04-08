package com.example.services;

import com.example.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product add(Product product);
    Product update(Product product);
    boolean deleteById(Long id);
    Product findById(Long id);
}
