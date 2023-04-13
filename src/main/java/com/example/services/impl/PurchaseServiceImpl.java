package com.example.services.impl;

import com.example.entities.Order;
import com.example.entities.Purchase;
import com.example.entities.enumclass.invoiceEnum;
import com.example.repositories.PurchaseRepo;
import com.example.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Purchase add(Purchase purchase) {
        purchase.setCreatedBy("Admin");
        purchase.setInvoice_stat(invoiceEnum.valueOf("unpaid"));
        return this.purchaseRepo.save(purchase);
    }

    @Override
    public Purchase update(Purchase purchase) {
        Purchase p = this.purchaseRepo.findById(purchase.getId()).orElse(null);
        if (p == null) {
            return null;
        }
        p.setUpdatedBy("Admin");
        p.setInvoice_stat(purchase.getInvoice_stat());
        p.setTotal_payment(purchase.getTotal_payment()); //will change later with auto calculation from tb_order_products
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
    public List<Purchase> findAll() {
        return this.purchaseRepo.findAll();
    }
}
