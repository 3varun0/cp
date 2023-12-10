package com.ms.project4.empmgmt.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EmployeeStub employeeStub;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeStub.getEmployees();
    }
}
