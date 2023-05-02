package com.example.controller;

import com.example.entities.*;
import com.example.entities.request.PurchaseProductAddRequest;
import com.example.entities.request.PurchaseProductUpdateRequest;
import com.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchaseProduct")
public class PurchaseProductController {
    private PurchaseProductService purchaseProductService;
    private PurchaseService purchaseService;
    private StockService stockService;

    @Autowired
    public PurchaseProductController(
            PurchaseProductService purchaseProductService,
            PurchaseService purchaseService,
            StockService stockService
    ){
        this.purchaseProductService = purchaseProductService;
        this.purchaseService = purchaseService;
        this.stockService = stockService;
    }
    @PostMapping("/create")
    public String addPurchaseProduct(@RequestBody PurchaseProductAddRequest req) {
        PurchaseProduct purchaseProduct = new PurchaseProduct();
        Purchase purchase = this.purchaseService.findById(req.getPurchaseId());
        Stock stock = this.stockService.findById(req.getStockId());
        if (purchase == null) {
            System.out.println("Purchase Id is not found!");
            return null;
        } else if (stock == null) {
            System.out.println("Stock Id is not found!");
            return null;
        } else {
            purchaseProduct.setPurchase(purchase);
            purchaseProduct.setStock(stock);
            purchaseProduct.setQty(req.getQty());
            purchaseProduct.setCost_price(req.getCostPrice());
            this.purchaseProductService.add(purchaseProduct);
            return "Added purchased product(s) successfully!";
        }
    }

    @PutMapping("/update")
    public String updatePurchaseProduct(@RequestBody PurchaseProductUpdateRequest req) {
        PurchaseProduct purchaseProduct = new PurchaseProduct();
        Purchase purchase = this.purchaseService.findById(req.getPurchaseId());
        Stock stock = this.stockService.findById(req.getStockId());
        if (purchase == null) {
            System.out.println("Purchase Id is not found!");
            return null;
        } else if (stock == null) {
            System.out.println("Stock Id is not found!");
            return null;
        } else {
            purchaseProduct.setPurchase(purchase);
            purchaseProduct.setStock(stock);
            purchaseProduct.setQty(req.getQty());
            purchaseProduct.setCost_price(req.getCostPrice());
            this.purchaseProductService.update(purchaseProduct);
            return "Updated ordered product(s) successfully!";
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.purchaseProductService.deleteById(id);
    }
}
