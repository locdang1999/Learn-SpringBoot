package com.danggialoc.learn.Springboot.tutorial.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danggialoc.learn.Springboot.tutorial.Entity.Department;
import com.danggialoc.learn.Springboot.tutorial.Service.DepartmentService;
import com.danggialoc.learn.Springboot.tutorial.error.DepartmentNotFoundExceoption;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return service.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		LOGGER.info("fetchDepartmentList LOC DANG");
		return service.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long id ) throws DepartmentNotFoundExceoption{
		return service.fetchDepartmentById(id);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long id ){
		service.deleteDepartmentById(id);
		return "Department deleted Successfully!!!";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long id, @RequestBody Department department){
		return service.updateDepartmentById(id,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String name ){
		return service.fetchDepartmentByName(name);
	}
}
