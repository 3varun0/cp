package com.ms.project6.empcrud.app.service;


import com.ms.project6.empcrud.app.entity.Employee;
import com.ms.project6.empcrud.app.exception.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int empId) throws EmployeeNotFoundException;

    Employee createEmployee(Employee e);

    Employee updateEmployee(Employee emp);

    Employee removeEmployee(int empId);

    ResponseEntity<List<Employee>> findByEmpName(String empName);

    ResponseEntity<List<Employee>> findByEmpSal(Float empId);

    ResponseEntity<List<Employee>> findByNameAndRole(String name, String role);

    ResponseEntity<List<Employee>> findBySalAbove(Float sal);

    ResponseEntity<List<Employee>> findByNameStartsWith(String nameInit);
}
