package com.danggialoc.springboot.hibernate.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danggialoc.springboot.hibernate.employee.model.Employee;
import com.danggialoc.springboot.hibernate.employee.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	@GetMapping("/emloyees")
	public ResponseEntity<Object> getAllEmployee(){
		List<Employee> employees = service.findAll();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
}
