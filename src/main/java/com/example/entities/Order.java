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
@Table(name = "tb_order")

public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)", updatable = false)
    private double total_payment;

    @Column(name = "invoice_status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private invoiceEnum invoice_stat;

    @OneToOne(mappedBy = "order")
    private OrderInvoice orderInvoice;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProductList;

}
