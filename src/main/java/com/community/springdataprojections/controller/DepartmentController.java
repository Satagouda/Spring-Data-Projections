package com.community.springdataprojections.controller;

import com.community.springdataprojections.entity.Department;
import com.community.springdataprojections.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping
    public List<Department> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public Department create(@Valid @RequestBody Department department){
        return service.create(department);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id,
                             @Valid @RequestBody Department department){
        return service.update(id, department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}