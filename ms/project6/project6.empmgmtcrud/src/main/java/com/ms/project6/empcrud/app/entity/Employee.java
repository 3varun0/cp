package com.ms.project6.empcrud.app.entity;

import javax.persistence.*;
@Entity
@Table(name = "employee", schema = "demodb")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long empId;

    @Column(name = "emp_name")
    public String empName;

    @Column(name = "emp_desig")
    public String empDesig;

    @Column(name = "emp_sal")
    public Float empSal;

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
