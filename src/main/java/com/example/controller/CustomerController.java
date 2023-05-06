package com.example.controller;

import com.example.entities.Customer;
import com.example.entities.projections.CustomerProjection;
import com.example.entities.request.CustomerAddRequest;
import com.example.entities.request.CustomerUpdateRequest;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
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
    public ApiResponse add(@RequestBody CustomerAddRequest req){
        Customer customer = new Customer();
        customer.setCus_name(req.getCusName());
        customer.setAge(req.getAge());
        customer.setGender(req.getGenderCode());
        customer.setPhone_num(req.getPhoneNum());
        this.customerService.add(customer);
        return new ApiResponse<>(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage());
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody CustomerUpdateRequest req){
        Customer customer = new Customer();
        customer.setId(req.getId());
        customer.setCus_name(req.getCusName());
        customer.setAge(req.getAge());
        customer.setGender(req.getGenderCode());
        customer.setPhone_num(req.getPhoneNum());
        customer.setStatus(req.getStatusCode());
        this.customerService.update(customer);
        return new ApiResponse<>(
                ApiStatus.SUC_UPDATED.getCode(),
                ApiStatus.SUC_UPDATED.getMessage());
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.customerService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
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
