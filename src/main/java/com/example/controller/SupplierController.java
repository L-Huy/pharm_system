package com.example.controller;

import com.example.entities.Supplier;
import com.example.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private SupplierService supplierService;
    @Autowired
    public SupplierController(
            SupplierService supplierService
    ){
        this.supplierService = supplierService;
    }

    @PostMapping("/create")
    public Supplier add(@RequestBody Supplier supplier){
        return this.supplierService.add(supplier);
    }

    @PutMapping("/update")
    public Supplier update(@RequestBody Supplier supplier){
        return this.supplierService.update(supplier);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.supplierService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Supplier findById(@PathVariable Long id){
        return this.supplierService.findById(id);
    }

    @GetMapping("/find")
    public List<Supplier> findAll(){
        return this.supplierService.findAll();
    }
}
