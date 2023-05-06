package com.example.controller;

import com.example.entities.*;
import com.example.entities.projections.OrderProjection;
import com.example.entities.request.OrderAddRequest;
import com.example.entities.request.OrderUpdateRequest;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/order")
public class OrderController {
    private OrderService orderService;
    private EmployeeService employeeService;
    private CustomerService customerService;
    private StockService stockService;

    @Autowired
    public OrderController(
            OrderService orderService,
            EmployeeService employeeService,
            CustomerService customerService,
            StockService stockService
    ){
        this.orderService = orderService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.stockService = stockService;
    }
    @PostMapping("/create")
    public ApiResponse addOrder(@RequestBody OrderAddRequest req) {
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
                order.setEmployee(employee);
                order.setCustomer(customer);
                this.orderService.add(order);
                return new ApiResponse<>(
                        ApiStatus.SUC_CREATED.getCode(),
                        ApiStatus.SUC_CREATED.getMessage());
        }
 /*     Error: can be insert and delete but does not link to tb_orderProduct
        //TODO: prepare employee object
        Employee employee = this.employeeService.findById(req.getEmployeeId());
        if(!ObjectUtils.isEmpty(employee)){
            order.setEmployee(employee);
        }else {
            return "Employee ID not found";
        }
        //TODO: prepare customer object
        Customer customer = this.customerService.findById(req.getCustomerId());
        if(!ObjectUtils.isEmpty(customer)){
            order.setCustomer(customer);
        }else {
            return "Customer ID not found";
        }
        // TODO: Prepare List of Product which order by user
        List<OrderProduct>orderProductList = new ArrayList<>();
        for(OrderProductReq orderProductReq : req.getOrderProductReqs()){
            Stock stock = this.stockService.findById(orderProductReq.getId());
            if(!ObjectUtils.isEmpty(stock)){
                OrderProduct orderProduct = new OrderProduct();

                orderProduct.setQty(orderProductReq.getQuantity());
                orderProduct.setSale_price(orderProductReq.getSalePrice());

                orderProduct.setStock(stock);
                orderProduct.setOrder(order);
                orderProductList.add(orderProduct);
            } else{
                System.out.println("Stock ID not found");
            }
        }
        order.setOrderProductList(orderProductList);
//        order.setOrderInvoice();
        this.orderService.add(order);
        return "Ordered Product(s) successfully!";*/
    }

    @PutMapping("/update")
    public ApiResponse updateOrder(@RequestBody OrderUpdateRequest req) {
        Order orderUpdate = new Order();
        Employee employee = this.employeeService.findById(req.getEmployeeId());
        Customer customer = this.customerService.findById(req.getCustomerId());
            if (employee == null) {
                System.out.println("Employee Id is not found!");
                return null;
            } else if (customer == null) {
                System.out.println("Customer Id is not found!");
                return null;
            } else {
                orderUpdate.setId(req.getId());
                orderUpdate.setEmployee(employee);
                orderUpdate.setCustomer(customer);
                orderUpdate.setStatus(req.getStatusCode());
                this.orderService.update(orderUpdate);
                return new ApiResponse<>(
                        ApiStatus.SUC_UPDATED.getCode(),
                        ApiStatus.SUC_UPDATED.getMessage());
        }
/*      Error: can be insert and delete but does not link to tb_orderProduct
        //TODO: prepare employee object
        Employee employee = this.employeeService.findById(req.getEmployeeId());
        if(!ObjectUtils.isEmpty(employee)){
            orderUpdate.setEmployee(employee);
        }else {
            return "Employee ID not found";
        }
        //TODO: prepare customer object
        Customer customer = this.customerService.findById(req.getCustomerId());
        if(!ObjectUtils.isEmpty(customer)){
            orderUpdate.setCustomer(customer);
        }else {
            return "Customer ID not found";
        }
        // TODO: Prepare update List of Product which order by user
        List<OrderProduct>orderProductList = new ArrayList<>();
        for(OrderProductReq orderProductReq : req.getOrderProductReqs()){
            Stock stock = this.stockService.findById(orderProductReq.getId());
            if(!ObjectUtils.isEmpty(stock)){
                OrderProduct orderProduct = new OrderProduct();

                orderProduct.setQty(orderProductReq.getQuantity());
                orderProduct.setSale_price(orderProductReq.getSalePrice());

                orderProduct.setStock(stock);
                orderProduct.setOrder(orderUpdate);
                orderProductList.add(orderProduct);
            } else{
                System.out.println("Stock ID not found");
            }
        }
        orderUpdate.getOrderProductList().clear();
        orderUpdate.getOrderProductList().addAll(orderProductList);
//        order.setOrderInvoice();
        this.orderService.update(orderUpdate);
        return "Update an order successfully!";*/

    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.orderService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
    }

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<OrderProjection> ord = this.orderService.findOrderProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", ord);
        map.put("pagination", p);
        return map;
    }
}
