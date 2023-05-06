package com.example.services.impl;

import com.example.entities.Supplier;
import com.example.entities.projections.ProductProjection;
import com.example.entities.projections.SupplierProjection;
import com.example.entities.response.pagination;
import com.example.repositories.SupplierRepo;
import com.example.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public List<SupplierProjection> findSupplierProjectionAll(pagination p) {
        Page<SupplierProjection> supp = supplierRepo.findAllSupplierProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(supp.getTotalElements());
        return supp.getContent() ;
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
        s.setId(supplier.getId());
        s.setCompany_name(supplier.getCompany_name());
        s.setSupplier_type(supplier.getSupplier_type());
        s.setPhone_num(supplier.getPhone_num());
        s.setAddress(supplier.getAddress());
        s.setStatus(supplier.getStatus());
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
