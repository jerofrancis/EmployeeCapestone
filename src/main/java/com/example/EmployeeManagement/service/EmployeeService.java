package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.dto.EmployeeDto;
import com.example.EmployeeManagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void save(EmployeeDto employeeDto);

    EmployeeDto getById(Long id);

    List<Employee> getAllEmployees();

    void deleteById(Long id);

    //update -> task
}
