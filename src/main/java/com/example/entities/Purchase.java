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

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseInvoice> purchaseInvoices;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseProduct> purchaseProductList;

}
