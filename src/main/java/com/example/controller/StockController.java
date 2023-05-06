package com.example.controller;

import com.example.entities.Product;
import com.example.entities.Stock;
import com.example.entities.Uom;
import com.example.entities.projections.ProductProjection;
import com.example.entities.projections.StockProjection;
import com.example.entities.request.StockAddRequest;
import com.example.entities.request.StockUpdateRequest;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
import com.example.entities.response.pagination;
import com.example.services.ProductService;
import com.example.services.StockService;
import com.example.services.UomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/stock")
public class StockController {
    private StockService stockService;
    private ProductService productService;
    private UomService uomService;

    @Autowired
    public StockController(
            StockService stockService,
            ProductService productService,
            UomService uomService
    ){
        this.stockService = stockService;
        this.productService = productService;
        this.uomService = uomService;
    }
    @PostMapping("/create")
    public ApiResponse addStock(@RequestBody StockAddRequest req) {
        Stock stock = new Stock();
        Product product = this.productService.findById(req.getProductId());
        Uom uom = this.uomService.findById(req.getUomId());
        if (product == null && uom == null) {
            System.out.println("Product/Uom is not found!");
            return null;
        }
        stock.setQty_on_hand(req.getQty_on_hand());
        stock.setUom(uom);
        stock.setProduct(product);
        this.stockService.add(stock);
        return new ApiResponse<>(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage());
    }


    @PutMapping("/update")
    public ApiResponse updateStock(@RequestBody StockUpdateRequest req) {
        Stock stock = new Stock();
        Product product = this.productService.findById(req.getProductId());
        Uom uom = this.uomService.findById(req.getUomId());
        if (product == null && uom == null) {
            System.out.println("Product/Uom is not found!");
            return null;
        }
        stock.setId(req.getId());
        stock.setQty_on_hand(req.getQty_on_hand());
        stock.setUom(uom);
        stock.setProduct(product);
        stock.setStatus(req.getStatusCode());
        this.stockService.update(stock);
        return new ApiResponse<>(
                ApiStatus.SUC_UPDATED.getCode(),
                ApiStatus.SUC_UPDATED.getMessage());
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.stockService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
    }

/*    @GetMapping("/find/{id}")
    public Stock findById(@PathVariable Long id){
        return this.stockService.findById(id);
    }*/

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<StockProjection> sto = this.stockService.findStockProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", sto);
        map.put("pagination", p);
        return map;
    }

}
