package com.community.springdataprojections.controller;

import com.community.springdataprojections.entity.Employee;
import com.community.springdataprojections.projection.EmployeeProjection;
import com.community.springdataprojections.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public List<Employee> getEmployees(){
        return service.getEmployees();
    }

    @GetMapping("/projection")
    public List<EmployeeProjection> getEmployeeProjection(){
        return service.getEmployeeProjections();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
    }
}