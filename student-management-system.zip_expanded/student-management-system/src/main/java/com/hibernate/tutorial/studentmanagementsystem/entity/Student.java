package com.hibernate.tutorial.studentmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String email;
	
	public Student(String firstName, String lastName, String email) {
		// TODO Auto-generated constructor stub
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
