package com.Employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer eid;
	@Column
	@NotBlank(message = "Employee name is required")
	private String ename;
	@Column
	@NotBlank(message="Employee role is required")
	private String erole;
	@Column
	@NotNull(message="Salary is required")
	@Positive(message="Salary must be greater than zero")
	private Double esalary;
	@Column
	@NotBlank(message="Date of joining is required")
	private String edoj;
}
