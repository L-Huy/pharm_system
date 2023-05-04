package com.example.services.impl;

import com.example.entities.Stock;
import com.example.entities.projections.ProductProjection;
import com.example.entities.projections.StockProjection;
import com.example.entities.response.pagination;
import com.example.repositories.StockRepo;
import com.example.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    private StockRepo stockRepo;
    @Autowired
    public StockServiceImpl(StockRepo stockRepo){
        this.stockRepo = stockRepo;
    }


    @Override
    public List<StockProjection> findStockProjectionAll(pagination p) {
        Page<StockProjection> sto = stockRepo.findAllStockProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(sto.getTotalElements());
        return sto.getContent() ;
    }

    @Override
    public Stock add(Stock stock) {
        stock.setCreatedBy("Admin");
        return this.stockRepo.save(stock);
    }

    @Override
    public Stock update(Stock stock) {
        Stock s = this.stockRepo.findById(stock.getId()).orElse(null);
        if (s == null) {
            return null;
        }
        s.setUpdatedBy("Admin");
        s.setQty_on_hand(stock.getQty_on_hand());
        s.setProduct(stock.getProduct());
        s.setUom(stock.getUom());
        return this.stockRepo.save(s);
    }

    @Override
    public boolean deleteById(Long id) {
        Stock stock = this.stockRepo.findById(id).orElse(null);
        if (stock == null){
            return false;
        }
        this.stockRepo.deleteById(id);
        return true;
    }

    @Override
    public Stock findById(Long id) {
        return this.stockRepo.findById(id).orElse(null);
    }
}
