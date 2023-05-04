package com.example.entities.projections;

import java.util.List;

public interface UomProjection {
    Long getId();
    String getUom_name();
    List<StockProjection> getStocks();
}
