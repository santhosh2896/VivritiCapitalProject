package com.VC.springRestfulWebservices.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VC.springRestfulWebservices.exception.ResourceNotFoundException;
import com.VC.springRestfulWebservices.model.Employee;
import com.VC.springRestfulWebservices.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeedb= this.employeeRepository.findById(employee.getUserId());
		
		if(employeedb.isPresent()) {
			Employee employeeUpdate= employeedb.get();
			employeeUpdate.setUserId(employee.getUserId());
			employeeUpdate.setFirstName(employee.getFirstName());
			employeeUpdate.setLastName(employee.getLastName());
			employeeUpdate.setAddress(employee.getAddress());
			employeeUpdate.setMobileNumber(employee.getMobileNumber());
			employeeUpdate.setDepartment(employee.getDepartment());
			return employeeUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not found with id"+ employee.getUserId());
		}
		
	}

	@Override
	public List<Employee> getallEmployee() {
		return this.employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(long userId) {
		Optional<Employee> employeedb= this.employeeRepository.findById(userId);
		
		if(employeedb.isPresent()) {
			this.employeeRepository.delete(employeedb.get());
			
		}
		else {
			throw new ResourceNotFoundException("Record not found with id"+ userId);
		}
		
	}
	
	

}
