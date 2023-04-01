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
@Table(name = "tb_purchaseINV")

public class PurchaseInvoice extends BaseEntity {
    @Column(length = 13, nullable = false)
    private String invoice;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double total_paid;

    @ManyToOne
    @JoinColumn(name = "paymentType_id")
    private PaymentType paymentType;


    @Column(name = "invoice_status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private invoiceEnum invoice_stat;

}
