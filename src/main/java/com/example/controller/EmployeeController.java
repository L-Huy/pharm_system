package com.example.controller;

import com.example.entities.Employee;
import com.example.entities.projections.CustomerProjection;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.response.pagination;
import com.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pharmpos/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(
            EmployeeService employeeService
    ){
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public Employee add(@RequestBody Employee employee){
        return this.employeeService.add(employee);
    }

    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return this.employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.employeeService.deleteById(id);
    }

/*    @GetMapping("/find/{id}")
    public Employee findById(@PathVariable Long id){
        return this.employeeService.findById(id);
    }*/

    @GetMapping("/findAll")
    public Map<String, Object> findAll(pagination p){
        List<EmployeeProjection> emp = this.employeeService.findEmployeeProjectionAll(p);
        Map<String, Object> map = new HashMap<>();
        map.put("data", emp);
        map.put("pagination", p);
        return map;
    }
}
