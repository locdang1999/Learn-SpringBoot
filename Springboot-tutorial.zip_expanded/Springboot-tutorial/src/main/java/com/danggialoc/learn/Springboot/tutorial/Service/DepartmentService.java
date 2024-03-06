package com.danggialoc.learn.Springboot.tutorial.Service;

import java.util.List;

import com.danggialoc.learn.Springboot.tutorial.Entity.Department;
import com.danggialoc.learn.Springboot.tutorial.error.DepartmentNotFoundExceoption;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long id) throws DepartmentNotFoundExceoption;

	public void deleteDepartmentById(Long id);

	public Department updateDepartmentById(Long id, Department department);

	public Department fetchDepartmentByName(String name);

}
