package com.example.entities;

import com.example.entities.mapperclass.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product")

public class Product extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String product_name;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double sale_price;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double cost_price;

    @Column(length = 100)
    private String treatment;

    @OneToMany(mappedBy = "product")
    private List<Stock> stocks;

    @OneToMany(mappedBy = "product")
    private List<PurchaseProduct> purchaseProductList;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProductList;

}
