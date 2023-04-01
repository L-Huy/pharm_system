package com.example.entities;

import com.example.entities.enumclass.invoiceEnum;
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
@Table(name = "tb_purchase")

public class Purchase extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)", updatable = false)
    private double total_payment;

    @Column(name = "invoice_status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private invoiceEnum invoice_stat;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseInvoice> purchaseInvoices;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseProduct> purchaseProductList;

}
