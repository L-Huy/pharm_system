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
@Table(name = "tb_stock")

public class Stock extends BaseEntity {

    @Column(nullable = false)
    private long qty_on_hand;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double sale_price;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double cost_price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "uom_id")
    private Uom uom;

    @OneToMany(mappedBy = "stock")
    private List<PurchaseProduct> purchaseProductList;

    @OneToMany(mappedBy = "stock")
    private List<OrderProduct> orderProductList;
}
