package com.danggialoc.learn.Springboot.tutorial.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.danggialoc.learn.Springboot.tutorial.Entity.ErrorManage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DepartmentNotFoundExceoption.class)
	public ResponseEntity<ErrorManage> departmentNotFoundException(DepartmentNotFoundExceoption exepction, WebRequest request) {
		ErrorManage message = new ErrorManage(HttpStatus.NOT_FOUND, exepction.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
}
