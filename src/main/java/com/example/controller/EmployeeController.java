package com.example.controller;

import com.example.entities.Employee;
import com.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
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

    @GetMapping("/find/{id}")
    public Employee findById(@PathVariable Long id){
        return this.employeeService.findById(id);
    }

    @GetMapping("/find")
    public List<Employee> findAll(){
        return this.employeeService.findAll();
    }
}
