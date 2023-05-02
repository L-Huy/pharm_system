package com.example.controller;

import com.example.entities.*;
import com.example.entities.request.PurchaseAddRequest;
import com.example.entities.request.PurchaseUpdateRequest;
import com.example.services.EmployeeService;
import com.example.services.PurchaseService;
import com.example.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
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
}
