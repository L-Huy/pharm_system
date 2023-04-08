package com.example.services.impl;

import com.example.entities.Uom;
import com.example.repositories.UomRepo;
import com.example.services.UomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UomServiceImpl implements UomService {
    private UomRepo uomRepo;
    @Autowired
    public UomServiceImpl(UomRepo uomRepo){
        this.uomRepo = uomRepo;
    }

    @Override
    public List<Uom> findAll() {
        return uomRepo.findAll();
    }

    @Override
    public Uom add(Uom uom) {
        uom.setCreatedBy("Admin");
        return uomRepo.save(uom);
    }

    @Override
    public Uom update(Uom uom) {
        Uom u = this.uomRepo.findById(uom.getId()).orElse(null);
        if(u == null){
            return null;
        }
        u.setUpdatedBy("Admin");
        u.setUom_name(uom.getUom_name());
        return this.uomRepo.save(u);
    }

    @Override
    public boolean deleteById(Long id) {
        Uom uom = this.uomRepo.findById(id).orElse(null);
        if(uom == null){
            return false;
        }
        uomRepo.deleteById(id);
        return true;
    }

    @Override
    public Uom findById(Long id) {
        return uomRepo.findById(id).orElse(null);
    }
}
