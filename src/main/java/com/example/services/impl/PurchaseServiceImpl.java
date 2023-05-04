package com.example.services.impl;

import com.example.entities.Purchase;
import com.example.entities.projections.OrderProjection;
import com.example.entities.projections.PurchaseProjection;
import com.example.entities.response.pagination;
import com.example.repositories.PurchaseRepo;
import com.example.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private PurchaseRepo purchaseRepo;
    @Autowired
    public PurchaseServiceImpl(PurchaseRepo purchaseRepo){
        this.purchaseRepo = purchaseRepo;
    }


    @Override
    public List<PurchaseProjection> findPurchaseProjectionAll(pagination p) {
        Page<PurchaseProjection> pur = purchaseRepo.findAllPurchaseProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(pur.getTotalElements());
        return pur.getContent() ;
    }

    @Override
    public Purchase add(Purchase purchase) {
        purchase.setCreatedBy("Admin");
        return this.purchaseRepo.save(purchase);
    }

    @Override
    public Purchase update(Purchase purchase) {
        Purchase p = this.purchaseRepo.findById(purchase.getId()).orElse(null);
        if (p == null) {
            return null;
        }
        p.setUpdatedBy("Admin");
        p.setEmployee(purchase.getEmployee());
        p.setSupplier(purchase.getSupplier());
        return this.purchaseRepo.save(p);
    }

    @Override
    public boolean deleteById(Long id) {
        Purchase purchase = this.purchaseRepo.findById(id).orElse(null);
        if (purchase == null){
            return false;
        }
        this.purchaseRepo.deleteById(id);
        return true;
    }

    @Override
    public Purchase findById(Long id) {
        return this.purchaseRepo.findById(id).orElse(null);
    }
}
