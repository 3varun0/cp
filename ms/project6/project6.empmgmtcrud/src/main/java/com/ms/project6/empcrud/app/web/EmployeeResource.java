package com.ms.project6.empcrud.app.web;

import com.ms.project6.empcrud.app.entity.Employee;
import com.ms.project6.empcrud.app.exception.EmpMgmtResponse;
import com.ms.project6.empcrud.app.exception.EmployeeNotFoundException;
import com.ms.project6.empcrud.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    //approach 1 for getEmployeeById() : for happy scenario
//    @GetMapping("/{empId}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
//
//        ResponseEntity<Employee> response = null;
//        try {
//            Employee emp = employeeService.getEmployeeById(empId);
//            response = new ResponseEntity<>(emp, HttpStatus.OK);
//
//        } catch (EmployeeNotFoundException ex) {
//            response = new ResponseEntity<>(HttpStatus.OK);
//        }
//        return response;
//    }

    //approach 2 for getEmployeeById() : for -ve scenario
    @GetMapping("/{empId}")
    public ResponseEntity<EmpMgmtResponse<Employee>> getEmployeeById(@PathVariable int empId) {

        ResponseEntity<EmpMgmtResponse<Employee>> response = null;
        Employee emp = null;
        try {
            emp = employeeService.getEmployeeById(empId);
            EmpMgmtResponse<Employee> empResponse = new EmpMgmtResponse<>(null, emp, null);
            response = new ResponseEntity<>(empResponse, HttpStatus.OK);

        } catch (EmployeeNotFoundException ex) {
            EmpMgmtResponse<Employee> empResponse = new EmpMgmtResponse<>(ex.getMessage(), emp, 9001L);
            response = new ResponseEntity<>(empResponse, HttpStatus.OK);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.createEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
        Object o = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(o , HttpStatus.OK);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<Object> removeEmployee(@PathVariable int empId) {
        Object o = employeeService.removeEmployee(empId);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

}
