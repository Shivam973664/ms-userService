package com.example.fastCurve.commonService;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.fastCurve.dao.EmployeeDaoInterface;
import com.example.fastCurve.dto.EmployeeDTO;
import com.example.fastCurve.entities.Employee;
import com.example.fastCurve.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private EmployeeDaoInterface dao;
	
	public ResponseEntity<List<Employee>> getEmployee(){
//		List<Employee> list = empRepository.findAll();
		List<Employee> list = dao.findAllEmployes();
		
		Predicate<Employee> p1 = (a)-> a.getEmployeeName().toLowerCase().startsWith("a");
		List<Employee> tempList = list.stream().filter(p1).collect(Collectors.toList());
		ResponseEntity<List<Employee>> response = new ResponseEntity(list,HttpStatus.OK);
		return response;
	}
	
	public ResponseEntity<String> postEmployee(EmployeeDTO dto ){
		Employee emp = new Employee();
//		emp.set
		emp.setEmployeeName(dto.getName());
		empRepository.save(emp);
		return ResponseEntity.ok("ok");
	}
	
	
	public ResponseEntity<Employee> updateEmployee(EmployeeDTO dto){
		Optional<Employee> emp = empRepository.findById(dto.getId());
		if(emp.isPresent()) {
			Employee realEmp = emp.get();
			realEmp.setEmployeeName(dto.getName());
			return ResponseEntity.ok(realEmp);
		}else {
			ResponseEntity<Employee> response = new ResponseEntity(emp,HttpStatus.BAD_REQUEST);
			return response;
		}
	}
	
	
	public ResponseEntity<Employee> deleteEmployee(EmployeeDTO dto){
		Optional<Employee> emp = empRepository.findById(dto.getId());
		if(emp.isPresent()) {
			Employee realEmp = emp.get();
			empRepository.delete(realEmp);
			return ResponseEntity.ok(realEmp);
		}else {
			ResponseEntity<Employee> response = new ResponseEntity(emp,HttpStatus.BAD_REQUEST);
			return response;
		}
	} 

}
