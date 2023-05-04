package com.example.controller;

import com.example.entities.Uom;
import com.example.entities.projections.SupplierProjection;
import com.example.entities.projections.UomProjection;
import com.example.entities.response.pagination;
import com.example.services.UomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/uom")
public class UomController {
    private UomService uomService;
    @Autowired
    public UomController(
            UomService uomService
    ){
        this.uomService = uomService;
    }

    @PostMapping("/create")
    public Uom add(@RequestBody Uom uom){
        return this.uomService.add(uom);
    }

    @PutMapping("/update")
    public Uom update(@RequestBody Uom uom){
        return this.uomService.update(uom);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.uomService.deleteById(id);
    }

/*    @GetMapping("/find/{id}")
    public Uom findById(@PathVariable Long id){
        return this.uomService.findById(id);
    }*/
    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<UomProjection> uom = this.uomService.findUomProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", uom);
        map.put("pagination", p);
        return map;
    }
}
