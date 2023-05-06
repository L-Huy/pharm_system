package com.example.controller;

import com.example.entities.Employee;
import com.example.entities.projections.CustomerProjection;
import com.example.entities.projections.EmployeeProjection;
import com.example.entities.request.EmployeeAddRequest;
import com.example.entities.request.EmployeeUpdateRequest;
import com.example.entities.response.ApiResponse;
import com.example.entities.response.ApiStatus;
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
    public ApiResponse add(@RequestBody EmployeeAddRequest req){
        Employee employee = new Employee();
        employee.setEmp_name(req.getEmpName());
        employee.setAge(req.getAge());
        employee.setGender(req.getGenderCode());
        employee.setPhone_num(req.getPhoneNum());
        employee.setHome_address(req.getHomeAddress());
        this.employeeService.add(employee);
        return new ApiResponse<>(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage());
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody EmployeeUpdateRequest req){
        Employee employee = new Employee();
        employee.setId(req.getId());
        employee.setEmp_name(req.getEmpName());
        employee.setAge(req.getAge());
        employee.setGender(req.getGenderCode());
        employee.setPhone_num(req.getPhoneNum());
        employee.setHome_address(req.getHomeAddress());
        employee.setStatus(req.getStatusCode());
        this.employeeService.update(employee);
        return new ApiResponse<>(
                ApiStatus.SUC_UPDATED.getCode(),
                ApiStatus.SUC_UPDATED.getMessage());
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Long id){
        this.employeeService.deleteById(id);
        return new ApiResponse<>(
                ApiStatus.SUC_DELETED.getCode(),
                ApiStatus.SUC_DELETED.getMessage());
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
