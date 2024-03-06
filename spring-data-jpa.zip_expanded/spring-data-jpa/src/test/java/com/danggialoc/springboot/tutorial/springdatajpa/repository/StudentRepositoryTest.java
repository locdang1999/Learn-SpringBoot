package com.danggialoc.springboot.tutorial.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danggialoc.springboot.tutorial.springdatajpa.model.Guardian;
import com.danggialoc.springboot.tutorial.springdatajpa.model.Student;

@SpringBootTest()
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository repository;

	@Test
	public void saveStudent() {
		Student student = Student.builder().emailId("locdang@gmail.com").firstName("Loc").lastName("Dang")
//				.guardianName("Kiu").guardianEmail("kiu@gmail.com").guardianMobile("0123456789")
				.build();
		repository.save(student);
	}

	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder().email("kiu321@gmail.com").name("Kiu123").mobile("0123456788").build();
		Student student = Student.builder().emailId("locdang32323@gmail.com").firstName("Loc").lastName("Dang Gia")
				.guardian(guardian).build();

		repository.save(student);
	}

	@Test
	public void printAllStudent() {
		List<Student> students = repository.findAll();
		System.out.println("studentList: " + students);
	}

	@Test
	public void printStudentByFirstName() {
		List<Student> students = repository.findByFirstName("Loc");
		System.out.println("Student: " + students);
	}

	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> students = repository.findByFirstNameContaining("L");
		System.out.println("Student: " + students);
	}

	@Test
	public void printStudentLastNameNotNull() {
		List<Student> students = repository.findByLastNameNotNull();
		System.out.println("Student: " + students);
	}

	@Test
	public void printStudentGuardianName() {
		List<Student> students = repository.findByGuardianName("Kiu");
		System.out.println("Student: " + students);
	}
	
	@Test
	public void updateStudentNameByEmailId() {
		repository.updateStudentNameByEmailId("Lộc", "locdang@gmail.com");
	}

}
