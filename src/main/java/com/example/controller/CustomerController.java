package com.example.controller;

import com.example.entities.Customer;
import com.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(
        CustomerService customerService
    ){
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public Customer add(@RequestBody Customer customer){
        return this.customerService.add(customer);
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer){
        return this.customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.customerService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Customer findById(@PathVariable Long id){
        return this.customerService.findById(id);
    }

    @GetMapping("/find")
    public List<Customer> findAll(){
        return this.customerService.findAll();
    }

}
