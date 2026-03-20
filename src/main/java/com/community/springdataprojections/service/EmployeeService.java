package com.community.springdataprojections.service;

import com.community.springdataprojections.entity.Employee;
import com.community.springdataprojections.projection.EmployeeProjection;
import com.community.springdataprojections.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public List<EmployeeProjection> getEmployeeProjections(){
        return repository.findAllProjectedBy();
    }

    public Employee createEmployee(Employee employee){
        return repository.save(employee);
    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }

    public Employee getEmployee(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, Employee employee){

        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setId(id);
        return repository.save(employee);
    }
}