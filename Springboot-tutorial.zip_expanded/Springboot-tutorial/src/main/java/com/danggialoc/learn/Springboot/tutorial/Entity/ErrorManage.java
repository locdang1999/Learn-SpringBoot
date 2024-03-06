package com.danggialoc.learn.Springboot.tutorial.Entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorManage {
	
	private HttpStatus status;
	private String message;
}
