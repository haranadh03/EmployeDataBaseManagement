package com.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.dto.EmployeeDto;
import com.Employee.entity.Employee;
import com.Employee.exception.EmployeeNotFoundException;
import com.Employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeDto addEmployee(Employee employee) {
		Employee dto=new Employee();
		dto.setEid(employee.getEid());
		dto.setEname(employee.getEname());
		dto.setEsalary(employee.getEsalary());
		dto.setErole(employee.getErole());
		dto.setEdoj(employee.getEdoj());
		return dto;
	}
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	public Employee getEmployeeById(int eid) {
		return employeeRepository.findById(eid).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id:"+ eid));
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
			throw new EmployeeNotFoundException("Employee not found");
		}
		employeeRepository.deleteById(eid);
	}
}
