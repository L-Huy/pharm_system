package com.example.entities;

import com.example.entities.mapperclass.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "tb_supplier")

public class Supplier extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String company_name;

    @Column(length = 100)
    private String supplier_type;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phone_num;

    @Column(name = "address", columnDefinition = "TEXT", nullable = false)
    private String address;

    @OneToMany(mappedBy = "supplier")
    private List<Purchase> purchaseList;

}
