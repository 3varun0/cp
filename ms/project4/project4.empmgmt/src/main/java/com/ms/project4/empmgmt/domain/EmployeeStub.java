package com.ms.project4.empmgmt.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeStub {

    private List<Employee> employees;

    public EmployeeStub() {
        employees = new ArrayList<>();
        employees.add(new Employee(1001, "Varun", 100000F, "SDE"));

        employees.add(new Employee(1001, "Amar", 15000F, "dba"));

        employees.add(new Employee(1001, "Kumar", 158000F, "SSE"));

        employees.add(new Employee(1001, "Om", 110000F, "Staff Engineer"));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
