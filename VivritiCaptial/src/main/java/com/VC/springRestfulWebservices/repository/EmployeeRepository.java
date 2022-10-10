package com.VC.springRestfulWebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VC.springRestfulWebservices.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
