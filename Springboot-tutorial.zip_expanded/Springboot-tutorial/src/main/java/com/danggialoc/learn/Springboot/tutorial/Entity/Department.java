package com.danggialoc.learn.Springboot.tutorial.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	@NotBlank(message = "Please Add Department Name")
	@Length(max = 50, min=5)
	@Size(max = 60, min = 0)
	/*
	 * @Email
	 * @Positive
	 * @Negative
	 * @PositiveOrZero
	 * @NegativeOrZero
	 * @Future
	 * @FutureOrPresent
	 * @Past
	 * @PastOrPresent*/
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
//	trong intellij nhấn alf + insert để gõ nhanh
}
