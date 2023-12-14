package com.ms.project6.empcrud.app.service;


import com.ms.project6.empcrud.app.entity.Employee;
import com.ms.project6.empcrud.app.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int empId) throws EmployeeNotFoundException;

    Employee createEmployee(Employee e);

    Employee updateEmployee(Employee emp);

    Employee removeEmployee(int empId);
}
