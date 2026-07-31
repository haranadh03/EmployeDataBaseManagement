package com.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Employee.entity.Employee;
import com.Employee.repository.EmployeeRepository;

public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	public Employee getEmployeeById(int eid) {
		return employeeRepository.findById(eid).orElseThrow(() -> new RuntimeException());
	}
	public Employee updateEmployee(int eid, Employee updatedEmployee) {
		Employee existing = getEmployeeById(eid);
		existing.setEname(updatedEmployee.getEname());
		existing.setErole(updatedEmployee.getErole());
		existing.setEsalary(updatedEmployee.getEsalary());
		existing.setEdoj(updatedEmployee.getEdoj());
		 return employeeRepository.save(existing);
	}
	public void deleteEmployee(int eid) {
		if(!employeeRepository.existsById(eid)) {
			throw new RuntimeException("Employee not found");
		}
		employeeRepository.deleteById(eid);
	}
}
