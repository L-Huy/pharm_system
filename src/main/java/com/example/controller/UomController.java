package com.example.controller;

import com.example.entities.Uom;
import com.example.entities.projections.SupplierProjection;
import com.example.entities.projections.UomProjection;
import com.example.entities.request.UomAddRequest;
import com.example.entities.request.UomUpdateRequest;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
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
    public ApiResponse add(@RequestBody UomAddRequest req){
        Uom uom = new Uom();
        uom.setUom_name(req.getUomName());
        this.uomService.add(uom);
        return new ApiResponse<>(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage());
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody UomUpdateRequest req){
        Uom uom = new Uom();
        uom.setId(req.getId());
        uom.setUom_name(req.getUomName());
        uom.setStatus(req.getStatusCode());
        this.uomService.update(uom);
        return new ApiResponse<>(
                ApiStatus.SUC_UPDATED.getCode(),
                ApiStatus.SUC_UPDATED.getMessage());
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.uomService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
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
