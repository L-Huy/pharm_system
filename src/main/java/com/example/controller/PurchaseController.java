package com.example.controller;

import com.example.entities.*;
import com.example.entities.projections.OrderProjection;
import com.example.entities.projections.PurchaseProjection;
import com.example.entities.request.PurchaseAddRequest;
import com.example.entities.request.PurchaseUpdateRequest;
import com.example.entities.response.pagination;
import com.example.services.EmployeeService;
import com.example.services.PurchaseService;
import com.example.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/purchase")
public class PurchaseController {
    private PurchaseService purchaseService;
    private EmployeeService employeeService;
    private SupplierService supplierService;

    @Autowired
    public PurchaseController(
            PurchaseService purchaseService,
            EmployeeService employeeService,
            SupplierService supplierService
    ){
        this.purchaseService = purchaseService;
        this.employeeService = employeeService;
        this.supplierService = supplierService;
    }
    @PostMapping("/create")
    public String addPurchase(@RequestBody PurchaseAddRequest req) {
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
            return "Added a purchase successfully!";
        }
    }

    @PutMapping("/update")
    public String updateOrder(@RequestBody PurchaseUpdateRequest req) {
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
            return "Updated a purchase successfully!";
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.purchaseService.deleteById(id);
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
