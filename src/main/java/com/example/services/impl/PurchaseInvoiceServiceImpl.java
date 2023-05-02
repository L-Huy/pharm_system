package com.example.services.impl;

import com.example.entities.PurchaseInvoice;
import com.example.repositories.PurchaseInvoiceRepo;
import com.example.services.PurchaseInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseInvoiceServiceImpl implements PurchaseInvoiceService {
    private PurchaseInvoiceRepo purchaseInvoiceRepo;
    @Autowired
    public PurchaseInvoiceServiceImpl(PurchaseInvoiceRepo purchaseInvoiceRepo){
        this.purchaseInvoiceRepo = purchaseInvoiceRepo;
    }


    @Override
    public PurchaseInvoice add(PurchaseInvoice purchaseInvoice) {
        purchaseInvoice.setCreatedBy("Admin");
        return this.purchaseInvoiceRepo.save(purchaseInvoice);
    }

    @Override
    public PurchaseInvoice update(PurchaseInvoice purchaseInvoice) {
        PurchaseInvoice pi = this.purchaseInvoiceRepo.findById(purchaseInvoice.getId()).orElse(null);
        if (pi == null) {
            return null;
        }
        pi.setUpdatedBy("Admin");
        pi.setPurchase(purchaseInvoice.getPurchase());
        pi.setPaymentType(purchaseInvoice.getPaymentType());
        pi.setTotal_paid(purchaseInvoice.getTotal_paid());
        return this.purchaseInvoiceRepo.save(pi);
    }

    @Override
    public boolean deleteById(Long id) {
        PurchaseInvoice purchaseInvoice = this.purchaseInvoiceRepo.findById(id).orElse(null);
        if (purchaseInvoice == null){
            return false;
        }
        this.purchaseInvoiceRepo.deleteById(id);
        return true;
    }

    @Override
    public List<PurchaseInvoice> findAll() {
        return this.purchaseInvoiceRepo.findAll();
    }
}
