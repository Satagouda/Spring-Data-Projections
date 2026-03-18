package com.community.springdataprojections.repository;

import com.community.springdataprojections.entity.Employee;
import com.community.springdataprojections.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    List<EmployeeProjection> findAllProjectedBy();
}
