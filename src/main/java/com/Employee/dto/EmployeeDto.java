package com.Employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EmployeeDto {
	
	private Integer eid;
	@NotBlank(message = "Employee name is required")
	private String ename;
	@NotBlank(message ="Employee role is required")
	private String erole;
	@NotNull(message = "Salary is required")
	@Positive(message = "Salary must be grated than zero")
	private Double esalary;
	@NotBlank(message="Date of joining is required")
	private String edoj;
}
