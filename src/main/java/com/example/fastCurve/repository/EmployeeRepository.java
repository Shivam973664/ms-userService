package com.example.fastCurve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fastCurve.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
}
