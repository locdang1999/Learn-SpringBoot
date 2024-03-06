package com.danggialoc.springboot.hibernate.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danggialoc.springboot.hibernate.employee.model.Employee;
import com.danggialoc.springboot.hibernate.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
