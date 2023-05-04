package com.example.controller;

import com.example.entities.Product;
import com.example.entities.projections.PaymentProjection;
import com.example.entities.projections.ProductProjection;
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
    public Product add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product){
        return this.productService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.productService.deleteById(id);
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
