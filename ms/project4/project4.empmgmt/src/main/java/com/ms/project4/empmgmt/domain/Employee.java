package com.ms.project4.empmgmt.domain;

public class Employee {
    Integer empId;
    String name;
    Float salary;

    String desig;

    public Employee(Integer empId, String name, Float salary, String desig) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.desig = desig;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }


}
