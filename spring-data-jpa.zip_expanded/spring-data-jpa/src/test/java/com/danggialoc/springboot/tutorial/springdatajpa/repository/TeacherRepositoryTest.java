package com.danggialoc.springboot.tutorial.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danggialoc.springboot.tutorial.springdatajpa.model.Course;
import com.danggialoc.springboot.tutorial.springdatajpa.model.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository repository;

//	@Test
//	public void saveTeacher() {
//		Course course = Course.builder().title("Spring boot").credit(5).build();
//
//		Course course_jsp = Course.builder().title("JSP Servelet").credit(10).build();
//
//		Teacher teacher = Teacher.builder().firstName("Anh").lastName("Nguyen").courses(List.of(course, course_jsp))
//				.build();
//
//		repository.save(teacher);
//	}
}
