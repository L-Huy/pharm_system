package com.example.controller;

import com.example.entities.*;
import com.example.entities.projections.OrderInvoiceProjection;
import com.example.entities.projections.OrderProjection;
import com.example.entities.request.OrderInvoiceAddRequest;
import com.example.entities.request.OrderInvoiceUpdateRequest;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.services.OrderInvoiceService;
import com.example.services.OrderService;
import com.example.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/orderInvoice")
public class OrderInvoiceController {
    private OrderInvoiceService orderInvoiceService;
    private OrderService orderService;
    private PaymentTypeService paymentTypeService;

    @Autowired
    public OrderInvoiceController(
            OrderInvoiceService orderInvoiceService,
            OrderService orderService,
            PaymentTypeService paymentTypeService
    ){
        this.orderInvoiceService = orderInvoiceService;
        this.orderService = orderService;
        this.paymentTypeService = paymentTypeService;
    }
    @PostMapping("/create")
    public ApiResponse addOrderInvoice(@RequestBody OrderInvoiceAddRequest req) {
        OrderInvoice orderInvoice = new OrderInvoice();
        Order order = this.orderService.findById(req.getOrderId());
        PaymentType paymentType = this.paymentTypeService.findById(req.getPaymentTypeId());
        if (order == null) {
            System.out.println("Order Id is not found!");
            return null;
        } else if (paymentType == null) {
            System.out.println("Payment Id is not found!");
            return null;
        } else {
            orderInvoice.setOrder(order);
            orderInvoice.setPaymentType(paymentType);
            orderInvoice.setTotal_paid(req.getTotalPaid());
            this.orderInvoiceService.add(orderInvoice);
            return new ApiResponse<>(
                    ApiStatus.SUC_CREATED.getCode(),
                    ApiStatus.SUC_CREATED.getMessage());
        }
    }

    @PutMapping("/update")
    public ApiResponse updateOrderProduct(@RequestBody OrderInvoiceUpdateRequest req) {
        OrderInvoice orderInvoice = new OrderInvoice();
        Order order = this.orderService.findById(req.getOrderId());
        PaymentType paymentType = this.paymentTypeService.findById(req.getPaymentTypeId());
        if (order == null) {
            System.out.println("Order Id is not found!");
            return null;
        } else if (paymentType == null) {
            System.out.println("Payment Id is not found!");
            return null;
        } else {
            orderInvoice.setId(req.getId());
            orderInvoice.setOrder(order);
            orderInvoice.setPaymentType(paymentType);
            orderInvoice.setTotal_paid(req.getTotalPaid());
            orderInvoice.setStatus(req.getStatusCode());
            this.orderInvoiceService.update(orderInvoice);
            return new ApiResponse<>(
                    ApiStatus.SUC_UPDATED.getCode(),
                    ApiStatus.SUC_UPDATED.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.orderInvoiceService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
    }

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<OrderInvoiceProjection> ord = this.orderInvoiceService.findOrderInvoiceProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", ord);
        map.put("pagination", p);
        return map;
    }
}
