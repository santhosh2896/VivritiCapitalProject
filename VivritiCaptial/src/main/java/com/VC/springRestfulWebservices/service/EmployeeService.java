package com.VC.springRestfulWebservices.service;

import java.util.List;

import com.VC.springRestfulWebservices.model.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	List<Employee> getallEmployee();
	void deleteEmployee(long userId);

	
}
