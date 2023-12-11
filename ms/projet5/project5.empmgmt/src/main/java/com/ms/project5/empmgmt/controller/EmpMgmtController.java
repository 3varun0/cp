package com.ms.project5.empmgmt.controller;

import com.ms.project5.empmgmt.entity.Employee;
import com.ms.project5.empmgmt.error.EmployeeNotFoundException;
import com.ms.project5.empmgmt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmpMgmtController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("alle")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /*@GetMapping()
    public Employee getEmployeeById(@PathVariable Long empId) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(empId);
    }*/

}
