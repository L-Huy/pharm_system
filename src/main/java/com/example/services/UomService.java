package com.example.services;

import com.example.entities.Uom;

import java.util.List;

public interface UomService {
//    List<Uom> findAll();
    Uom add(Uom uom);
    Uom update(Uom uom);
    boolean deleteById(Long id);
    Uom findById(Long id);
}
