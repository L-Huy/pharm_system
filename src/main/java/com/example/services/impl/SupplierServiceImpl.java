package com.example.services.impl;

import com.example.entities.Supplier;
import com.example.repositories.SupplierRepo;
import com.example.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepo supplierRepo;

    @Autowired
    public SupplierServiceImpl (SupplierRepo supplierRepo){
        this.supplierRepo = supplierRepo;
    }
    @Override
    public List<Supplier> findAll() {
        return this.supplierRepo.findAll();
    }

    @Override
    public Supplier add(Supplier supplier) {
        return this.supplierRepo.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        Supplier s = this.supplierRepo.findById(supplier.getId()).orElse(null);
        if(s == null){
            return null;
        }
        s.setUpdatedBy("Admin");
        s.setCompany_name(supplier.getCompany_name());
        s.setSupplier_type(supplier.getSupplier_type());
        s.setPhone_num(supplier.getPhone_num());
        s.setAddress(supplier.getAddress());
        return this.supplierRepo.save(s);
    }

    @Override
    public boolean deleteById(Long id) {
        Supplier supplier = this.supplierRepo.findById(id).orElse(null);
        if(supplier == null){
            return false;
        }
        supplierRepo.deleteById(id);
        return true;
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepo.findById(id).orElse(null);
    }
}
