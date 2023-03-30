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
@Table(name = "tb_employee")

public class Employee extends BaseEntity {

    @Column(name = "name", length = 100, nullable = false)
    private String emp_name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private genderEnum gender;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phone_num;

    @Column(name = "home_address", columnDefinition = "TEXT", nullable = false)
    private String home_address;

    @OneToMany(mappedBy = "employee")
    private List<Purchase> purchaseList;

    @OneToMany(mappedBy = "employee")
    private List<Order> orderList;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
