package com.example.controller;

import com.example.entities.*;
import com.example.entities.projections.OrderProductProjection;
import com.example.entities.request.OrderProductAddRequest;
import com.example.entities.request.OrderProductUpdateRequest;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/orderProduct")
public class OrderProductController {
    private OrderProductService orderProductService;
    private OrderService orderService;
    private StockService stockService;

    @Autowired
    public OrderProductController(
            OrderProductService orderProductService,
            OrderService orderService,
            StockService stockService
    ){
        this.orderProductService = orderProductService;
        this.orderService = orderService;
        this.stockService = stockService;
    }
    @PostMapping("/create")
    public ApiResponse addOrderProduct(@RequestBody OrderProductAddRequest req) {
        OrderProduct orderProduct = new OrderProduct();
        Order order = this.orderService.findById(req.getOrderId());
        Stock stock = this.stockService.findById(req.getStockId());
        if (order == null) {
            System.out.println("Order Id is not found!");
            return null;
        } else if (stock == null) {
            System.out.println("Stock Id is not found!");
            return null;
        } else {
            orderProduct.setOrder(order);
            orderProduct.setStock(stock);
            orderProduct.setQty(req.getQty());
            orderProduct.setSale_price(req.getSalePrice());
            this.orderProductService.add(orderProduct);
            return new ApiResponse<>(
                    ApiStatus.SUC_CREATED.getCode(),
                    ApiStatus.SUC_CREATED.getMessage());
        }
    }

    @PutMapping("/update")
    public ApiResponse updateOrderProduct(@RequestBody OrderProductUpdateRequest req) {
        OrderProduct orderProduct = new OrderProduct();
        Order order = this.orderService.findById(req.getOrderId());
        Stock stock = this.stockService.findById(req.getStockId());
        if (order == null) {
            System.out.println("Order Id is not found!");
            return null;
        } else if (stock == null) {
            System.out.println("Stock Id is not found!");
            return null;
        } else {
            orderProduct.setId(req.getId());
            orderProduct.setOrder(order);
            orderProduct.setStock(stock);
            orderProduct.setQty(req.getQty());
            orderProduct.setSale_price(req.getSalePrice());
            orderProduct.setStatus(req.getStatusCode());
            this.orderProductService.update(orderProduct);
            return new ApiResponse<>(
                    ApiStatus.SUC_UPDATED.getCode(),
                    ApiStatus.SUC_UPDATED.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.orderProductService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
    }

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<OrderProductProjection> ord = this.orderProductService.findOrderProductProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", ord);
        map.put("pagination", p);
        return map;
    }
}

