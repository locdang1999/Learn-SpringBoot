package com.danggialoc.learn.Springboot.tutorial.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.danggialoc.learn.Springboot.tutorial.Entity.Department;
import com.danggialoc.learn.Springboot.tutorial.Repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService service;

	@MockBean
	private DepartmentRepository repository;

	@BeforeEach
	void setUp() {
		Department department = Department.builder().departmentName("IT").departmentAddress("GV").departmentCode("GL")
				.departmentId(1L).build();
		Mockito.when(repository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
	}

	@Test
	@DisplayName("Get Data based on valida Department Name")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department found = service.fetchDepartmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
	}

}
