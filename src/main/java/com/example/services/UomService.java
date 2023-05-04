package com.example.services;

import com.example.entities.Uom;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.projections.UomProjection;
import com.example.entities.response.pagination;

import java.util.List;

public interface UomService {
    List<UomProjection> findUomProjectionAll(pagination p);
    Uom add(Uom uom);
    Uom update(Uom uom);
    boolean deleteById(Long id);
    Uom findById(Long id);

}
