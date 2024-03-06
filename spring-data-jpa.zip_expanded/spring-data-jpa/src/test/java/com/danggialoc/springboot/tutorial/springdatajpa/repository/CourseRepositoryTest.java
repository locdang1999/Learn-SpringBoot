package com.danggialoc.springboot.tutorial.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.danggialoc.springboot.tutorial.springdatajpa.model.Course;
import com.danggialoc.springboot.tutorial.springdatajpa.model.Student;
import com.danggialoc.springboot.tutorial.springdatajpa.model.Teacher;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository repository;

	@Test
	public void SaveCoursewWithTeacher() {
		Teacher teacher = Teacher.builder().firstName("Hoa").lastName("Nguyen").build();

		Course course = Course.builder().title("C++").credit(6).teacher(teacher).build();

		repository.save(course);
	}

	@Test
	public void printCourse() {
		List<Course> course = repository.findAll();

		System.out.println("Course: " + course);
	}

	@Test
	public void findAllPagination() {
		Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

		List<Course> courses = repository.findAll(firstPagewithThreeRecords).getContent();
		List<Course> courses2 = repository.findAll(secondPageWithTwoRecords).getContent();

		long totalElements = repository.findAll(firstPagewithThreeRecords).getTotalElements();

		long totalPages = repository.findAll(firstPagewithThreeRecords).getTotalPages();

		System.out.println("TotalPages: " + totalPages);

		System.out.println("TotalElements: " + totalElements);

		System.out.println("Courses page 1: " + courses);

		System.out.println("Courses page 2: " + courses2);
	}

	@Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

		List<Course> courses = repository.findAll(sortByTitle).getContent();

		System.out.println("Courses: " + courses);

	}

	@Test
	public void printFindByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);

		List<Course> courses = repository.findByTitleContaining("j", firstPageTenRecords).getContent();

		System.out.println("Courses: " + courses);
	}

	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder().firstName("Minh").lastName("Tran").build();

		Student student = Student.builder().firstName("Khanh").lastName("Nguyen").emailId("khanhnguyen@gmail.com")
				.build();

		Course course = Course.builder().title("AI").credit(21).teacher(teacher).build();

		course.addStudents(student);

		repository.save(course);
	}

}
