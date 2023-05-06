package com.example.controller;

import com.example.entities.*;
import com.example.entities.projections.PurchaseInvoiceProjection;
import com.example.entities.projections.PurchaseProjection;
import com.example.entities.request.PurchaseInvoiceAddRequest;
import com.example.entities.request.PurchaseInvoiceUpdateRequest;
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
@RequestMapping("/api/v1/pharmpos/purchaseInvoice")
public class PurchaseInvoiceController {
    private PurchaseInvoiceService purchaseInvoiceService;
    private PurchaseService purchaseService;
    private PaymentTypeService paymentTypeService;

    @Autowired
    public PurchaseInvoiceController(
            PurchaseInvoiceService purchaseInvoiceService,
            PurchaseService purchaseService,
            PaymentTypeService paymentTypeService
    ){
        this.purchaseInvoiceService = purchaseInvoiceService;
        this.purchaseService = purchaseService;
        this.paymentTypeService = paymentTypeService;
    }
    @PostMapping("/create")
    public ApiResponse addOrderInvoice(@RequestBody PurchaseInvoiceAddRequest req) {
        PurchaseInvoice purchaseInvoice = new PurchaseInvoice();
        Purchase purchase = this.purchaseService.findById(req.getPurchaseId());
        PaymentType paymentType = this.paymentTypeService.findById(req.getPaymentTypeId());
        if (purchase == null) {
            System.out.println("Purchase Id is not found!");
            return null;
        } else if (paymentType == null) {
            System.out.println("Payment Id is not found!");
            return null;
        } else {
            purchaseInvoice.setPurchase(purchase);
            purchaseInvoice.setPaymentType(paymentType);
            purchaseInvoice.setTotal_paid(req.getTotalPaid());
            this.purchaseInvoiceService.add(purchaseInvoice);
            return new ApiResponse<>(
                    ApiStatus.SUC_CREATED.getCode(),
                    ApiStatus.SUC_CREATED.getMessage());
        }
    }

    @PutMapping("/update")
    public ApiResponse updateOrderProduct(@RequestBody PurchaseInvoiceUpdateRequest req) {
        PurchaseInvoice purchaseInvoice = new PurchaseInvoice();
        Purchase purchase = this.purchaseService.findById(req.getPurchaseId());
        PaymentType paymentType = this.paymentTypeService.findById(req.getPaymentTypeId());
        if (purchase == null) {
            System.out.println("Purchase Id is not found!");
            return null;
        } else if (paymentType == null) {
            System.out.println("Payment Id is not found!");
            return null;
        } else {
            purchaseInvoice.setId(req.getId());
            purchaseInvoice.setPurchase(purchase);
            purchaseInvoice.setPaymentType(paymentType);
            purchaseInvoice.setTotal_paid(req.getTotalPaid());
            purchaseInvoice.setStatus(req.getStatusCode());
            this.purchaseInvoiceService.add(purchaseInvoice);
            return new ApiResponse<>(
                    ApiStatus.SUC_UPDATED.getCode(),
                    ApiStatus.SUC_UPDATED.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.purchaseInvoiceService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
    }

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<PurchaseInvoiceProjection> pur = this.purchaseInvoiceService.findPurchaseInvoiceProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", pur);
        map.put("pagination", p);
        return map;
    }
}
