package com.example.EmployeeManagement.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name cant be null")
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @NotBlank
    private String department;

    @NotBlank
    private String jobtitle;

}
