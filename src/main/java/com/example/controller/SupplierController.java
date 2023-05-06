package com.example.controller;

import com.example.entities.Supplier;
import com.example.entities.projections.ProductProjection;
import com.example.entities.projections.SupplierProjection;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/supplier")
public class SupplierController {
    private SupplierService supplierService;
    @Autowired
    public SupplierController(
            SupplierService supplierService
    ){
        this.supplierService = supplierService;
    }

    @PostMapping("/create")
    public ApiResponse add(@RequestBody Supplier supplier){
        supplier.setCompany_name(supplier.getCompany_name());
        supplier.setSupplier_type(supplier.getSupplier_type());
        supplier.setAddress(supplier.getAddress());
        supplier.setPhone_num(supplier.getPhone_num());
        this.supplierService.add(supplier);
        return new ApiResponse<>(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage());
    }

    @PutMapping("/update")
    public Supplier update(@RequestBody Supplier supplier){
        supplier.setId(supplier.getId());
        supplier.setCompany_name(supplier.getCompany_name());
        supplier.setSupplier_type(supplier.getSupplier_type());
        supplier.setAddress(supplier.getAddress());
        supplier.setPhone_num(supplier.getPhone_num());
        supplier.setStatus(supplier.getStatus());
        return this.supplierService.update(supplier);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.supplierService.deleteById(id);
    }

/*    @GetMapping("/find/{id}")
    public Supplier findById(@PathVariable Long id){
        return this.supplierService.findById(id);
    }*/

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<SupplierProjection> supp = this.supplierService.findSupplierProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", supp);
        map.put("pagination", p);
        return map;
    }
}
