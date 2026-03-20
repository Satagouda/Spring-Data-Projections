package com.community.springdataprojections.projection;


import com.community.springdataprojections.entity.Department;

public interface EmployeeProjection {

    String getPosition();

    String getDepartmentName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    Department getDepartment();

    String getFirstName();
    String getLastName();
}