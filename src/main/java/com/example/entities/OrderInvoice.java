package com.example.entities;

import com.example.entities.enumclass.invoiceEnum;
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
@Table(name = "tb_orderINV")

public class OrderInvoice extends BaseEntity {
    @Column(length = 13, nullable = false)
    private String invoice;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double total_paid;

    @ManyToOne
    @JoinColumn(name = "paymentType_id")
    private PaymentType paymentType;

}
