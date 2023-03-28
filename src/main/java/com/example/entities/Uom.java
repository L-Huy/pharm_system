package com.example.entities;

import com.example.entities.mapperclass.BaseEntity;
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
@Table(name = "tb_uom")

public class Uom extends BaseEntity {
    private String uom_name;

    @OneToMany(mappedBy = "uom")
    private List<Stock> stocks;


}
