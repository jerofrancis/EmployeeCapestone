package com.example.EmployeeManagement.service.impl;

import com.example.EmployeeManagement.dto.EmployeeDto;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelmapper;

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public void save(EmployeeDto employeeDto) {
        employeeRepository.save(modelmapper.map(employeeDto, Employee.class));
    }

    @Override
    public EmployeeDto getById(Long id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;

        if(optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        }else {
            throw new RuntimeException("Employee not Fount for id : " + id);
        }

        return modelmapper.map(employeeRepository.getById(id), EmployeeDto.class);
    }

    @Override
    public List<Employee> getAllEmployees() {
        logger.info("Inside Employee Service Impl");
        return employeeRepository.findAll();
    }

    //task -> write method for update

    @Override
    public void deleteById(Long id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;
        String response = null;

        if(optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
            response = "Employee Deleted Successfully";
        }else {
            response = "Please check your id, couldn't delete employee";
            throw new RuntimeException("Employee not Fount for id : " + id);
        }

        employeeRepository.deleteById(id);

//        return response;
    }
}
