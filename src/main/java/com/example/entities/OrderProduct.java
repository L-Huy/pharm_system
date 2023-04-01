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
@Table(name = "tb_order_products")

public class OrderProduct extends BaseEntity {

    @Column(nullable = false, updatable = false)
    private int qty;

    @Column(nullable = false, updatable = false, columnDefinition = "DECIMAL(10,2)")
    private double sale_price;

    @Column(nullable = false, updatable = false, columnDefinition = "DECIMAL(10,2)")
    private double total_sale;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_of_stockId")
    private Stock stock;

}
