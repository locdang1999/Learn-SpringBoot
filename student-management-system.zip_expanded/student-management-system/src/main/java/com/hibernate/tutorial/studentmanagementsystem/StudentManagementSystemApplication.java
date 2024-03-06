package com.hibernate.tutorial.studentmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.tutorial.studentmanagementsystem.entity.Student;
import com.hibernate.tutorial.studentmanagementsystem.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Student std1 = new Student("Loc", "Dang","locdang@gmail.com");
//		repository.save(std1);
//		Student std2 = new Student("Loc1", "Dang","locdang123@gmail.com");
//		repository.save(std2);
//		Student std3 = new Student("Loc1", "Dang","locdang12@gmail.com");
//		repository.save(std3);
		
	}

}
