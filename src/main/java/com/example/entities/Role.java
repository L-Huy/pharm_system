package com.example.entities;

import com.example.entities.mapperclass.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_roles")
public class Role extends BaseEntity {

    @Column(nullable = false)
    private String role_of_employee;

    @OneToOne(mappedBy = "role")
    private Employee employee;
}
