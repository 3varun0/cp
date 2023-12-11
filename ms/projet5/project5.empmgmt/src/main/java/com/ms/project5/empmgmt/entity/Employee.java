package com.ms.project5.empmgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = "demodb")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private Long empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_desig")
    private String empDesig;
    @Column(name = "emp_sal")
    private Float empSal;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
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
