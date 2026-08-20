package com.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.entity.Employee;
import com.Employee.service.EmployeeService;

import jakarta.validation.Valid;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		Employee saved =employeeService.addEmployee(employee);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	@GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // READ ONE
    @GetMapping("/{eid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int eid) {
        return ResponseEntity.ok(employeeService.getEmployeeById(eid));
    }

    // UPDATE
    @PutMapping("/{eid}")
    public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable int eid, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(eid, employee));
    }

    // DELETE
    @DeleteMapping("/{eid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int eid) {
        employeeService.deleteEmployee(eid);
        return ResponseEntity.ok("Employee with id " + eid + " deleted successfully");
    }
}
