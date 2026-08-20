package com.Employee;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Employee.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class GlobalException {
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ResponseEntity<Map<String,Object>>handleExceptionNotFoundException(EmployeeNotFoundException ex){
//		Map<String, Object>body = new HashMap<>();
//		
//	}
}
