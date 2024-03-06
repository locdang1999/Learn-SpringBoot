package com.danggialoc.springboot.tutorial.springdatajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.danggialoc.springboot.tutorial.springdatajpa.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	Page<Course> findByTitleContaining(String title, Pageable pageable);

}
