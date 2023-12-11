package com.ms.project5.empmgmt.service;

import com.ms.project5.empmgmt.entity.Employee;
import com.ms.project5.empmgmt.entity.EmployeeRepository;
import com.ms.project5.empmgmt.error.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();// == SELECT * FROM employees;
    }

    /*@Override
    public Employee getEmployeeById(Long empId) throws EmployeeNotFoundException {
        return employeeRepository.findById(empId).orElseGet(Employee::new);
    }*/
}
