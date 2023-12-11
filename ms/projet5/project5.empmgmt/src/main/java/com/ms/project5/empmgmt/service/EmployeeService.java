package com.ms.project5.empmgmt.service;

import com.ms.project5.empmgmt.entity.Employee;
import com.ms.project5.empmgmt.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    //Employee getEmployeeById(Long empId) throws EmployeeNotFoundException;
}
