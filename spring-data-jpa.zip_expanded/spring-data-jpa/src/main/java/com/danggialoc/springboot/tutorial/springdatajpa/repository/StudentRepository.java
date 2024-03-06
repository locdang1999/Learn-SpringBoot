package com.danggialoc.springboot.tutorial.springdatajpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danggialoc.springboot.tutorial.springdatajpa.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByFirstName(String firstName);

	List<Student> findByFirstNameContaining(String name);

	List<Student> findByLastNameNotNull();

	List<Student> findByGuardianName(String guardianName);

	Student findByFirstNameAndLastName(String firstName, String lastName);

	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailId(String emailId);

	@Query("select s.firstName from Student s where s.emailId = ?1")
	String getStudentFirstNameByEmailId(String emailId);

	// query native
	@Query(value = "select * from tbl_student s where s.email = ?1", nativeQuery = true)
	Student getStudentByEmailIdNative(String emailId);

	// query native param
	@Query(value = "select * from tbl_student s where s.email = :emailId", nativeQuery = true)
	Student getStudentByEmailIdNativeNamedParam(@Param("emailId") String emailId);

	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name = ?1 where email = ?2 ", nativeQuery = true)
	int updateStudentNameByEmailId(String firstName, String emailId);

}
