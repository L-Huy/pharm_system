package com.example.services.impl;

import com.example.entities.PurchaseInvoice;
import com.example.entities.projections.PurchaseInvoiceProjection;
import com.example.entities.projections.PurchaseProjection;
import com.example.entities.response.pagination;
import com.example.repositories.PurchaseInvoiceRepo;
import com.example.services.PurchaseInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public List<PurchaseInvoiceProjection> findPurchaseInvoiceProjectionAll(pagination p) {
        Page<PurchaseInvoiceProjection> pur = purchaseInvoiceRepo.findAllPurchaseInvoiceProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(pur.getTotalElements());
        return pur.getContent() ;
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
        pi.setId(purchaseInvoice.getId());
        pi.setPurchase(purchaseInvoice.getPurchase());
        pi.setPaymentType(purchaseInvoice.getPaymentType());
        pi.setTotal_paid(purchaseInvoice.getTotal_paid());
        pi.setStatus(purchaseInvoice.getStatus());
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
    public PurchaseInvoice findById(Long id) {
        return this.purchaseInvoiceRepo.findById(id).orElse(null);
    }

}
