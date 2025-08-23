package com.example.fastCurve.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fastCurve.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmployeeDao implements EmployeeDaoInterface{

	@Autowired
	private EntityManager enitityManager;
	
//	private EntityManagerFactory entitymanagerFactory;
	
	public List<Employee> findAllEmployes() {
//		enitityManager.b();
//		enitityManager=entitymanagerFactory.createEntityManager();
//		enitityManager.getTransaction().begin();
		
		List<Employee> employees = enitityManager.createQuery("select a from Employee a", Employee.class)
				.getResultList();
//		enitityManager.getTransaction().commit();
//		enitityManager.close();
		return employees;
//		enitityManager.
	}

}
