package com.example.controller;

import com.example.entities.*;
import com.example.entities.projections.PurchaseProductProjection;
import com.example.entities.projections.PurchaseProjection;
import com.example.entities.request.PurchaseProductAddRequest;
import com.example.entities.request.PurchaseProductUpdateRequest;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/purchaseProduct")
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
    public ApiResponse addPurchaseProduct(@RequestBody PurchaseProductAddRequest req) {
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
            return new ApiResponse<>(
                    ApiStatus.SUC_CREATED.getCode(),
                    ApiStatus.SUC_CREATED.getMessage());
        }
    }

    @PutMapping("/update")
    public ApiResponse updatePurchaseProduct(@RequestBody PurchaseProductUpdateRequest req) {
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
            purchaseProduct.setId(req.getPurchaseId());
            purchaseProduct.setPurchase(purchase);
            purchaseProduct.setStock(stock);
            purchaseProduct.setQty(req.getQty());
            purchaseProduct.setCost_price(req.getCostPrice());
            purchaseProduct.setStatus(req.getStatusCode());
            this.purchaseProductService.update(purchaseProduct);
            return new ApiResponse<>(
                    ApiStatus.SUC_UPDATED.getCode(),
                    ApiStatus.SUC_UPDATED.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.purchaseProductService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
    }

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<PurchaseProductProjection> pur = this.purchaseProductService.findPurchaseProductProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", pur);
        map.put("pagination", p);
        return map;
    }
}
