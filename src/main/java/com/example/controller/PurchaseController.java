package com.example.controller;

import com.example.entities.*;
import com.example.entities.projections.PurchaseProjection;
import com.example.entities.request.PurchaseAddRequest;
import com.example.entities.request.PurchaseUpdateRequest;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.services.EmployeeService;
import com.example.services.PurchaseService;
import com.example.services.StockService;
import com.example.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/purchase")
public class PurchaseController {
    private PurchaseService purchaseService;
    private EmployeeService employeeService;
    private SupplierService supplierService;
    private StockService stockService;

    @Autowired
    public PurchaseController(
            PurchaseService purchaseService,
            EmployeeService employeeService,
            SupplierService supplierService,
            StockService stockService
    ){
        this.purchaseService = purchaseService;
        this.employeeService = employeeService;
        this.supplierService = supplierService;
        this.stockService = stockService;
    }
    @PostMapping("/create")
    public ApiResponse addPurchase(@RequestBody PurchaseAddRequest req) {
        Purchase purchase = new Purchase();
        Employee employee = this.employeeService.findById(req.getEmployeeId());
        Supplier supplier = this.supplierService.findById(req.getSupplierId());
        if (employee == null) {
                System.out.println("Employee Id is not found!");
                return null;
            } else if (supplier == null) {
                System.out.println("Supplier Id is not found!");
                return null;
            } else {
                purchase.setEmployee(employee);
                purchase.setSupplier(supplier);
                this.purchaseService.add(purchase);
                return new ApiResponse<>(
                    ApiStatus.SUC_CREATED.getCode(),
                    ApiStatus.SUC_CREATED.getMessage());
        }
/*        //TODO: prepare employee object
        Employee employee = this.employeeService.findById(req.getEmployeeId());
        if(!ObjectUtils.isEmpty(employee)){
            purchase.setEmployee(employee);
        }else {
            return "Employee ID not found";
        }
        //TODO: prepare customer object
        Supplier supplier = this.supplierService.findById(req.getSupplierId());
        if(!ObjectUtils.isEmpty(supplier)){
            purchase.setSupplier(supplier);
        }else {
            return "Supplier ID not found";
        }
        // TODO: Prepare List of Product which order by user
        List<PurchaseProduct> purchaseProductList = new ArrayList<>();
        for(PurchaseProductReq purchaseProductReq : req.getPurchaseProductReqs()){
            Stock stock = this.stockService.findById(purchaseProductReq.getId());
            if(!ObjectUtils.isEmpty(stock)){
                PurchaseProduct purchaseProduct = new PurchaseProduct();

                purchaseProduct.setQty(purchaseProductReq.getQuantity());
                purchaseProduct.setCost_price(purchaseProductReq.getCostPrice());

                purchaseProduct.setStock(stock);
                purchaseProduct.setPurchase(purchase);
                purchaseProductList.add(purchaseProduct);
            } else{
                System.out.println("Stock ID not found");
            }
        }
        purchase.setPurchaseProductList(purchaseProductList);
//        order.setOrderInvoice();
        this.purchaseService.add(purchase);
        return "Purchased Product(s) successfully!";*/

    }

    @PutMapping("/update")
    public ApiResponse updatePurchase(@RequestBody PurchaseUpdateRequest req) {
        Purchase purchaseUpdate = new Purchase();
        Employee employee = this.employeeService.findById(req.getEmployeeId());
        Supplier supplier = this.supplierService.findById(req.getSupplierId());
        if (employee == null) {
            System.out.println("Employee Id is not found!");
            return null;
        } else if (supplier == null) {
            System.out.println("Supplier Id is not found!");
            return null;
        } else {
            purchaseUpdate.setId(req.getId());
            purchaseUpdate.setEmployee(employee);
            purchaseUpdate.setSupplier(supplier);
            purchaseUpdate.setStatus(req.getStatusCode());
            this.purchaseService.add(purchaseUpdate);
            return new ApiResponse<>(
                    ApiStatus.SUC_UPDATED.getCode(),
                    ApiStatus.SUC_UPDATED.getMessage());
        }
/*      //TODO: prepare employee object
        Employee employee = this.employeeService.findById(req.getEmployeeId());
        if(!ObjectUtils.isEmpty(employee)){
            purchaseUpdate.setEmployee(employee);
        }else {
            return "Employee ID not found";
        }
        //TODO: prepare customer object
        Supplier supplier = this.supplierService.findById(req.getSupplierId());
        if(!ObjectUtils.isEmpty(supplier)){
            purchaseUpdate.setSupplier(supplier);
        }else {
            return "Supplier ID not found";
        }
        // TODO: Prepare update List of Product which order by user
        List<PurchaseProduct>purchaseProductList = new ArrayList<>();
        for(PurchaseProductReq purchaseProductReq : req.getPurchaseProductReqs()){
            Stock stock = this.stockService.findById(purchaseProductReq.getId());
            if(!ObjectUtils.isEmpty(stock)){
                PurchaseProduct purchaseProduct = new PurchaseProduct();

                purchaseProduct.setQty(purchaseProductReq.getQuantity());
                purchaseProduct.setCost_price(purchaseProductReq.getCostPrice());

                purchaseProduct.setStock(stock);
                purchaseProduct.setPurchase(purchaseUpdate);
                purchaseProductList.add(purchaseProduct);
            } else{
                System.out.println("Stock ID not found");
            }
        }
        purchaseUpdate.getPurchaseProductList().clear();
        purchaseUpdate.getPurchaseProductList().addAll(purchaseProductList);
//        order.setOrderInvoice();
        this.purchaseService.update(purchaseUpdate);
        return "Update a purchase successfully!";*/

    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.purchaseService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
    }

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<PurchaseProjection> pur = this.purchaseService.findPurchaseProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", pur);
        map.put("pagination", p);
        return map;
    }
}
