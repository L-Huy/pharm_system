package com.example.services.impl;

import com.example.entities.Employee;
import com.example.repositories.EmployeeRepo;
import com.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    @Override
    public List<Employee> findAll() {
        return this.employeeRepo.findAll();
    }

    @Override
    public Employee add(Employee employee) {
        return this.employeeRepo.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        Employee e = this.employeeRepo.findById(employee.getId()).orElse(null);
        if(e == null){
            return null;
        }
        e.setUpdatedBy("Admin");
        e.setEmp_name(employee.getEmp_name());
        e.setAge(employee.getAge());
        e.setPhone_num(employee.getPhone_num());
        e.setGender(employee.getGender());
        e.setHome_address(employee.getHome_address());
        return this.employeeRepo.save(e);
    }

    @Override
    public boolean deleteById(Long id) {
        Employee employee = this.employeeRepo.findById(id).orElse(null);
        if(employee == null) {
            return false;
        }
        employeeRepo.deleteById(id);
        return true;
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepo.findById(id).orElse(null);
    }
}
