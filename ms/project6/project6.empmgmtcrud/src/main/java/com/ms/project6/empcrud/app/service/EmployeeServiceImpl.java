package com.ms.project6.empcrud.app.service;

import com.ms.project6.empcrud.app.entity.Employee;
import com.ms.project6.empcrud.app.entity.EmployeeRepository;
import com.ms.project6.empcrud.app.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int empId) throws EmployeeNotFoundException {

        //approach 1 for happy scenario
        //return employeeRepository.findById((long)empId).orElseGet(Employee::new);

        //approach 2 for -ve scenario
        return employeeRepository.findById((long)empId).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Employee removeEmployee(int empId) {
        Employee emp = employeeRepository.findById((long)empId).orElseGet(Employee::new);
        employeeRepository.delete(emp);
        return emp;
    }
}
