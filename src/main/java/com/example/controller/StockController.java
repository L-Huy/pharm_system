package com.example.controller;

import com.example.entities.Product;
import com.example.entities.Stock;
import com.example.entities.Uom;
import com.example.entities.request.StockAddRequest;
import com.example.entities.request.StockUpdateRequest;
import com.example.services.ProductService;
import com.example.services.StockService;
import com.example.services.UomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
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
    public String addStock(@RequestBody StockAddRequest req) {
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
        return "Added a stock successfully!";
    }


    @PutMapping("/update")
    public String updateStock(@RequestBody StockUpdateRequest req) {
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
        this.stockService.update(stock);
        return "Updated a stock successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.stockService.deleteById(id);
    }

//    @GetMapping("/find")
//    public List<Stock> findAll(){
//        return this.stockService.findAll();
//    }

}
