package com.example.services.impl;

import com.example.configuration.exception.NotFoundException;
import com.example.configuration.exception.TransactionException;
import com.example.entities.Customer;
import com.example.entities.projections.CustomerProjection;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.repositories.CustomerRepo;
import com.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
        Customer addCustomer = null;
        try{
            customer.setCreatedBy("Admin");
            addCustomer = customerRepo.save(customer);
        } catch (Exception e){
            e.printStackTrace();
            throw new TransactionException(
                ApiStatus.FAI_CREATED.getCode(),
                ApiStatus.FAI_CREATED.getMessage()
            );
        }
        return addCustomer;
    }

    @Override
    public Customer update(Customer customer) {
        Customer c = this.customerRepo.findById(customer.getId()).orElseThrow(() -> new NotFoundException(
                ApiStatus.NOT_FOUND.getCode(), ApiStatus.NOT_FOUND.getMessage()));

        if(c == null){
            return null;
        }
        c.setUpdatedBy("Admin");
        c.setId(customer.getId());
        c.setCus_name(customer.getCus_name());
        c.setAge(customer.getAge());
        c.setPhone_num(customer.getPhone_num());
        c.setGender(customer.getGender());
        c.setStatus(customer.getStatus());
        return this.customerRepo.save(c);
    }

    @Override
    public boolean deleteById(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new NotFoundException(
                ApiStatus.NOT_FOUND.getCode(), ApiStatus.NOT_FOUND.getMessage()));
        if(!ObjectUtils.isEmpty(customer)){
            customerRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }
}
