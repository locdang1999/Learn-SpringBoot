package com.danggialoc.springboot.tutorial.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danggialoc.springboot.tutorial.springdatajpa.model.Course;
import com.danggialoc.springboot.tutorial.springdatajpa.model.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository repository;

//	@Test
//	public void SaveCourseMaterial() {
//		Course course = Course.builder().title("java").credit(6).build();
//
//		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
//
//		repository.save(courseMaterial);
//	}

	@Test
	public void printAllCourseMaterials() {
		System.out.println("dsds");
		List<CourseMaterial> courseMaterials = repository.findAll();

		System.out.println("CourseMaterial: " + courseMaterials);
	}

}
