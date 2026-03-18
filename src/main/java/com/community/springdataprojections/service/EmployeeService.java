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
}