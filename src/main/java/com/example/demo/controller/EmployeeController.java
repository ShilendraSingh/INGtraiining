package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@PostMapping("/saveemployee")
	public ResponseEntity<Employee> saveemployee(Employee newEmp) {
		// employeeservice.save(newEmp);
		return new ResponseEntity<Employee>(employeeservice.save(newEmp), HttpStatus.OK);

	}

	@GetMapping("/getemployee/{id}")
	public ResponseEntity<Employee> getemployee(@PathVariable Long id) {

		return new ResponseEntity<Employee>(employeeservice.getById(id), HttpStatus.OK);

	}

	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		employeeservice.deleteEmployee(id);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@GetMapping("/getAllemployee")
	public ResponseEntity<List<Employee>> getallEmployee(Employee employee) {
		List<Employee> all = employeeservice.getAll(employee);
		return new ResponseEntity<List<Employee>>(all, HttpStatus.OK);
	}

	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<String> updateemployee(Employee employee) {
		employeeservice.updateemployee(employee);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

}
