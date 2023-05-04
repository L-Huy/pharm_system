package com.example.entities.projections;

import com.example.entities.enumclass.genderEnum;

import java.util.List;

public interface CustomerProjection {
    Long getId();
    String getCus_name();
    genderEnum getGender();
    Integer getAge();
    String getPhone_num();
    List<OrderProjection> getOrderList();
}
