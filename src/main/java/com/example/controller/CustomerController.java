package com.example.controller;

import com.example.entities.Customer;
import com.example.entities.projections.CustomerProjection;
import com.example.entities.response.pagination;
import com.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/customer")
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

/*    @GetMapping("/find/{id}")
    public Customer findById(@PathVariable Long id){
        return this.customerService.findById(id);
    }*/

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<CustomerProjection> cus = this.customerService.findCustomerProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", cus);
        map.put("pagination", p);
        return map;
    }

}
