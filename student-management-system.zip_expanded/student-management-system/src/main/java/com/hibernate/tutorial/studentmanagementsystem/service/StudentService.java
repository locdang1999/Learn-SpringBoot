package com.hibernate.tutorial.studentmanagementsystem.service;

import java.util.List;

import com.hibernate.tutorial.studentmanagementsystem.entity.Student;

public interface StudentService {
	List<Student> getAllStudent();
	
	Student save(Student Student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);

	void deleteStudent(Long id);
}
