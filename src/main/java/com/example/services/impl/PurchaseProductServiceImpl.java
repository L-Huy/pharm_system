package com.example.services.impl;

import com.example.entities.PurchaseProduct;
import com.example.entities.projections.OrderProductProjection;
import com.example.entities.projections.PurchaseProductProjection;
import com.example.entities.response.pagination;
import com.example.repositories.PurchaseProductRepo;
import com.example.services.PurchaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseProductServiceImpl implements PurchaseProductService {
    private PurchaseProductRepo purchaseProductRepo;
    @Autowired
    public PurchaseProductServiceImpl(PurchaseProductRepo purchaseProductRepo){
        this.purchaseProductRepo = purchaseProductRepo;
    }


    @Override
    public List<PurchaseProductProjection> findPurchaseProductProjectionAll(pagination p) {
        Page<PurchaseProductProjection> pur = purchaseProductRepo.findAllPurchaseProductProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(pur.getTotalElements());
        return pur.getContent() ;
    }

    @Override
    public PurchaseProduct add(PurchaseProduct purchaseProduct) {
        purchaseProduct.setCreatedBy("Admin");
        return this.purchaseProductRepo.save(purchaseProduct);
    }

    @Override
    public PurchaseProduct update(PurchaseProduct purchaseProduct) {
        PurchaseProduct pp = this.purchaseProductRepo.findById(purchaseProduct.getId()).orElse(null);
        if (pp == null) {
            return null;
        }
        pp.setUpdatedBy("Admin");
        pp.setId(purchaseProduct.getId());
        pp.setPurchase(purchaseProduct.getPurchase());
        pp.setStock(purchaseProduct.getStock());
        pp.setQty(purchaseProduct.getQty());
        pp.setCost_price(purchaseProduct.getCost_price());
        pp.setStatus(purchaseProduct.getStatus());
        return this.purchaseProductRepo.save(pp);
    }

    @Override
    public boolean deleteById(Long id) {
        PurchaseProduct purchaseProduct = this.purchaseProductRepo.findById(id).orElse(null);
        if (purchaseProduct == null){
            return false;
        }
        this.purchaseProductRepo.deleteById(id);
        return true;
    }

    @Override
    public PurchaseProduct findById(Long id) {
        return this.purchaseProductRepo.findById(id).orElse(null);
    }

}
