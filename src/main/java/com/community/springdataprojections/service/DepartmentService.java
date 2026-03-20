package com.community.springdataprojections.service;

import com.community.springdataprojections.entity.Department;
import com.community.springdataprojections.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;

    public List<Department> getAll(){
        return repository.findAll();
    }

    public Department get(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department create(Department department){
        return repository.save(department);
    }

    public Department update(Long id, Department department){
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        department.setId(id);
        return repository.save(department);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}