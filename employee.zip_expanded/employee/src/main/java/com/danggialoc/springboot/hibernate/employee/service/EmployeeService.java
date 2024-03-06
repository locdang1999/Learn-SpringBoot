package com.danggialoc.springboot.hibernate.employee.service;

import java.util.List;

import com.danggialoc.springboot.hibernate.employee.model.Employee;

public interface EmployeeService {
	List<Employee> findAll();
}
