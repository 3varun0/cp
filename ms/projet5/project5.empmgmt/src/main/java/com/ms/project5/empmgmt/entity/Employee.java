package com.ms.project5.empmgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    Integer empId;
    @Column(name = "empName")
    String empName;
    @Column(name = "empDesig")
    String empDesig;
    @Column(name = "empSal")
    Float empSal;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesig() {
        return empDesig;
    }

    public void setEmpDesig(String empDesig) {
        this.empDesig = empDesig;
    }

    public Float getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Float empSal) {
        this.empSal = empSal;
    }
}
