package com.hibernate.tutorial.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.tutorial.studentmanagementsystem.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
