package com.VC.springRestfulWebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VC.springRestfulWebservices.model.Employee;
import com.VC.springRestfulWebservices.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok().body(employeeService.getallEmployee());
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
		employee.setUserId(id);
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable long id){
		this.employeeService.deleteEmployee(id);
		return "User Deleted Successfully";
		
	}

}
