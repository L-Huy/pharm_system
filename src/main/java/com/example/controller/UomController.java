package com.example.controller;

import com.example.entities.Uom;
import com.example.services.UomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uom")
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

    @GetMapping("/find/{id}")
    public Uom findById(@PathVariable Long id){
        return this.uomService.findById(id);
    }

    @GetMapping("/find")
    public List<Uom> findAll(){
        return this.uomService.findAll();
    }
}
