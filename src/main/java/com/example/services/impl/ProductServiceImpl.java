package com.example.services.impl;

import com.example.entities.Product;
import com.example.entities.projections.PaymentProjection;
import com.example.entities.projections.ProductProjection;
import com.example.entities.response.pagination;
import com.example.repositories.ProductRepo;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }


    @Override
    public List<ProductProjection> findProductProjectionAll(pagination p) {
        Page<ProductProjection> prod = productRepo.findAllProductProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(prod.getTotalElements());
        return prod.getContent() ;
    }

    @Override
    public Product add(Product product) {
        product.setCreatedBy("Admin");
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        Product p = this.productRepo.findById(product.getId()).orElse(null);
        if(p == null){
            return null;
        }
        p.setUpdatedBy("Admin");
        p.setProduct_name(product.getProduct_name());
        p.setTreatment(product.getTreatment());
        return this.productRepo.save(p);
    }

    @Override
    public boolean deleteById(Long id) {
        Product product = this.productRepo.findById(id).orElse(null);
        if(product == null){
            return false;
        }
        productRepo.deleteById(id);
        return true;
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
}
