package com.ms.project5.empmgmt.controller;

import com.ms.project5.empmgmt.entity.Employee;
import com.ms.project5.empmgmt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class EmpMgmtController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("{/id}")
    public Employee findEmployeeById() {
        return employeeService.findEmployeeById();
    }

}
