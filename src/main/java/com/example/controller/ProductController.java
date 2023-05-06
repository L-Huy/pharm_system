package com.example.controller;

import com.example.entities.Product;
import com.example.entities.projections.PaymentProjection;
import com.example.entities.projections.ProductProjection;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/product")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(
            ProductService productService
    ){
        this.productService = productService;
    }

    @PostMapping("/create")
    public ApiResponse add(@RequestBody Product product){
        product.setProduct_name(product.getProduct_name());
        product.setTreatment(product.getTreatment());
        this.productService.add(product);
        return new ApiResponse<>(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage());
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody Product product){
        product.setId(product.getId());
        product.setProduct_name(product.getProduct_name());
        product.setTreatment(product.getTreatment());
        product.setStatus(product.getStatus());
        this.productService.update(product);
        return new ApiResponse<>(
                ApiStatus.SUC_UPDATED.getCode(),
                ApiStatus.SUC_UPDATED.getMessage());
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.productService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
    }

/*    @GetMapping("/find/{id}")
    public Product findById(@PathVariable Long id){
        return this.productService.findById(id);
    }*/

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<ProductProjection> prod = this.productService.findProductProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", prod);
        map.put("pagination", p);
        return map;
    }
}
