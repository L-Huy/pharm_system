package com.example.entities.projections;

import java.util.List;

public interface ProductProjection {
    Long getId();
    String getProduct_name();
    String getTreatment();
    List<StockProjection> getStocks();

}
