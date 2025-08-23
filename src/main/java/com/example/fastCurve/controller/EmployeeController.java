package com.example.fastCurve.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fastCurve.commonService.EmployeeService;
import com.example.fastCurve.dto.EmployeeDTO;
import com.example.fastCurve.entities.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/api/employee")
	public ResponseEntity<List<Employee>> getEmployees(){
		
		return empService.getEmployee();
		
	}
	
	@PostMapping("/api/postEmployee")
	public ResponseEntity<String> postEmployee(@RequestBody EmployeeDTO employeeDto){
		return empService.postEmployee(employeeDto);
	}
	//open api
	//swagger
	
	@PutMapping("/api/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody  EmployeeDTO employeeDto) {
		return empService.updateEmployee(employeeDto);
	}
	
//	@DeleteMapping
	
	@GetMapping("/api/getPaymentOptionOfUser")
	public ResponseEntity<List<String>> getPaymentOption(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(Arrays.asList("Go TO Bank","Use AtM near by"));
	}
	
	
	
}
