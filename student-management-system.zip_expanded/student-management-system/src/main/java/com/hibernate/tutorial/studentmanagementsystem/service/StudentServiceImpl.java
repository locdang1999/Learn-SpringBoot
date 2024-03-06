package com.hibernate.tutorial.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.tutorial.studentmanagementsystem.entity.Student;
import com.hibernate.tutorial.studentmanagementsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
