package com.example.entities.projections;

import com.example.entities.enumclass.genderEnum;

import java.util.List;

public interface EmployeeProjection {
    Long getId();
    String getEmp_name();
    genderEnum getGender();
    Integer getAge();
    String getPhone_num();
    String getHome_address();
    List<PurchaseProjection> getPurchaseList();
    List<OrderProjection> getOrderList();

}
