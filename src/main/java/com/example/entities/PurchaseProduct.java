package com.example.entities;

import com.example.entities.mapperclass.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_purchase_products")

public class PurchaseProduct extends BaseEntity {

    @Column(nullable = false, updatable = false)
    private int qty;

    @Column(nullable = false, updatable = false)
    private double purchase_price;

    @Column(nullable = false, updatable = false)
    private double total_purchase;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
