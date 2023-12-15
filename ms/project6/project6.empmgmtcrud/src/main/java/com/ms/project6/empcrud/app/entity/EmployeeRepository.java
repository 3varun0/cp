package com.ms.project6.empcrud.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByEmpName(String empName);
    List<Employee> findByEmpSal(Float empSal);

    //JPQL + positional parameters
    //@Query(value = "SELECT emp FROM Employee emp where emp.empName = ?1 and emp.empDesig = ?2", nativeQuery = false)

    //JPQL + named parameters
    @Query(value = "SELECT emp FROM Employee emp where emp.empName = :name and emp.empDesig = :desig", nativeQuery = false)

    List<Employee> findByNameAndDesig(String name, String desig);

    //JPQL + positional parameters
    @Query( value = "SELECT emp FROM Employee emp WHERE emp.empSal > ?1", nativeQuery = false)
    List<Employee> findBySalAbove(Float sal);

    //JPQL + positional parameters + use of @Param for diff names
    @Query(value = "SELECT * FROM employee emp WHERE emp.emp_name like :namedParam%", nativeQuery = true)
    List<Employee> findByNameStartsWith(@Param(value = "namedParam") String nameInit);
}
