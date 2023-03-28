package com.example.entities;

import com.example.entities.enumclass.genderEnum;
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
@Table(name = "tb_customer")

public class Customer extends BaseEntity {

    @Column(name = "name", length = 100, nullable = false)
    private String cus_name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private genderEnum gender;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phone_num;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;

}
