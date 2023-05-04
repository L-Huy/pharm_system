package com.example.entities.projections;

import java.util.List;

public interface SupplierProjection {
    Long getId();
    String getCompany_name();
    String getSupplier_type();
    String getPhone_num();
    String getAddress();
    List<PurchaseProjection> getPurchaseList();
}
