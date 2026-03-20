package com.community.springdataprojections.controller;

import com.community.springdataprojections.entity.Department;
import com.community.springdataprojections.entity.Employee;
import com.community.springdataprojections.repository.DepartmentRepository;
import com.community.springdataprojections.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void testProjectionEndpoint() throws Exception {


        Department dept = new Department();
        dept.setName("Engineering");
        departmentRepository.save(dept);


        Employee emp = new Employee();
        emp.setFirstName("John");
        emp.setLastName("Doe");
        emp.setPosition("Developer");
        emp.setSalary(50000.0);
        emp.setDepartment(dept);

        employeeRepository.save(emp);


        mockMvc.perform(get("/employees/projection"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fullName").value("John Doe"))
                .andExpect(jsonPath("$[0].position").value("Developer"))
                .andExpect(jsonPath("$[0].department.name").value("Engineering"))
                .andExpect(jsonPath("$[0].salary").doesNotExist()); // projection check
    }
}