package com.community.springdataprojections.repository;

import com.community.springdataprojections.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {
}
