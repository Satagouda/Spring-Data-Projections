package com.community.springdataprojections.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name required")
    private String firstName;

    @NotBlank(message = "Last name Required")
    private String lastName;

    @NotBlank
    private String position;

    @Min(0)
    private Double salary;

    @ManyToOne
    private Department department;
}
