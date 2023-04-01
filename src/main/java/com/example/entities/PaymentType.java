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
@Table(name = "tb_payment")
public class PaymentType extends BaseEntity {

    @Column(nullable = false)
    private String payment_type;

    @OneToMany(mappedBy = "paymentType")
    private List<OrderInvoice> orderInvoices;

    @OneToMany(mappedBy = "paymentType")
    private List<PurchaseInvoice> purchaseInvoices;
}
