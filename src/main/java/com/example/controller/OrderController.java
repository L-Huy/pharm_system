package com.example.controller;

import com.example.entities.*;
import com.example.entities.enumclass.invoiceEnum;
import com.example.entities.request.OrderAddRequest;
import com.example.entities.request.OrderUpdateRequest;
import com.example.services.CustomerService;
import com.example.services.EmployeeService;
import com.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    private EmployeeService employeeService;
    private CustomerService customerService;

    @Autowired
    public OrderController(
            OrderService orderService,
            EmployeeService employeeService,
            CustomerService customerService
    ){
        this.orderService = orderService;
        this.employeeService = employeeService;
        this.customerService = customerService;
    }
    @PostMapping("/create")
    public String addOrder(@RequestBody OrderAddRequest req) {
        Order order = new Order();
        Employee employee = this.employeeService.findById(req.getEmployeeId());
        Customer customer = this.customerService.findById(req.getCustomerId());
        if (employee == null) {
            System.out.println("Employee Id is not found!");
            return null;
        } else if (customer == null) {
            System.out.println("Customer Id is not found!");
            return null;
        } else {
            order.setTotal_payment(req.getTotalPayment());
            order.setEmployee(employee);
            order.setCustomer(customer);
            this.orderService.add(order);
            return "Added an order successfully!";
        }
    }

    @PutMapping("/update")
    public String updateOrder(@RequestBody OrderUpdateRequest req) {
        Order order = new Order();
        Employee employee = this.employeeService.findById(req.getEmployeeId());
        Customer customer = this.customerService.findById(req.getCustomerId());
        if (employee == null) {
            System.out.println("Employee Id is not found!");
            return null;
        } else if (customer == null) {
            System.out.println("Customer Id is not found!");
            return null;
        } else {
            order.setInvoice_stat(invoiceEnum.valueOf(req.getInvoiceStat()));
            order.setTotal_payment(req.getTotalPayment());
            order.setEmployee(employee);
            order.setCustomer(customer);
            this.orderService.update(order);
            return "Updated an order successfully!";
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.orderService.deleteById(id);
    }
}
