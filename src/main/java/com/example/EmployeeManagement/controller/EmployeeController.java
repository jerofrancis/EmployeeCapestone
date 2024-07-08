package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.dto.EmployeeDto;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){

        model.addAttribute("allemplist", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model){
        //map to dto & handle entity
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee")EmployeeDto employeeDto){
        employeeService.save(employeeDto);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model){
        EmployeeDto employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteById(@PathVariable(value = "id") Long id){
        //map to dto & handle entity
        employeeService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/ShowEmp")
    public String getEmployee(@RequestParam long id, Model model) {
        EmployeeDto employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "individualView";
    }

}
