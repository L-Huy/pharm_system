package com.example.services.impl;

import com.example.entities.Uom;
import com.example.entities.projections.SupplierProjection;
import com.example.entities.projections.UomProjection;
import com.example.entities.response.pagination;
import com.example.repositories.UomRepo;
import com.example.services.UomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public List<UomProjection> findUomProjectionAll(pagination p) {
        Page<UomProjection> uom = uomRepo.findAllUomProjectionBy(
                PageRequest.of(p.getPage()-1, p.getSize())
        );
        p.setTotalCounts(uom.getTotalElements());
        return uom.getContent() ;
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
        u.setId(uom.getId());
        u.setUom_name(uom.getUom_name());
        u.setStatus(uom.getStatus());
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
