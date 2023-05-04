package com.example.services.impl;

import com.example.entities.Customer;
import com.example.entities.projections.CustomerProjection;
import com.example.entities.response.pagination;
import com.example.repositories.CustomerRepo;
import com.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }


    @Override
    public List<CustomerProjection> findCustomerProjectionAll(pagination p) {
        Page<CustomerProjection> cus = customerRepo.findAllCustomerProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(cus.getTotalElements());
        return cus.getContent() ;
    }

    @Override
    public Customer add(Customer customer) {
        customer.setCreatedBy("Admin");
        return customerRepo.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        Customer c = this.customerRepo.findById(customer.getId()).orElse(null);
        if(c == null){
            return null;
        }
        c.setUpdatedBy("Admin");
        c.setCus_name(customer.getCus_name());
        c.setAge(customer.getAge());
        c.setPhone_num(customer.getPhone_num());
        c.setGender(customer.getGender());
        return this.customerRepo.save(c);
    }

    @Override
    public boolean deleteById(Long id) {
        Customer customer = this.customerRepo.findById(id).orElse(null);
        if(customer == null){
            return false;
        }
        customerRepo.deleteById(id);
        return true;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }
}
