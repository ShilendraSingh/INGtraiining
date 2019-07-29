package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public  Employee saveemployee (Employee newEmp){
		return employeeservice.save(newEmp);
	
		}
	
	@GetMapping("/getemployee/{id}")
	public Employee getemployee(@PathVariable Long id)
	{
	Employee E3	= employeeservice.getById(id);
		return E3;
		
	}
	
	
	@DeleteMapping("/deleteemployee/{id}")
	public void deleteEmployee(@PathVariable Long id)
	{
		employeeservice.deleteEmployee(id);
		
		}

	@GetMapping("/getAllemployee")
	public List<Employee> getallEmployee(Employee employee)
	{
	return employeeservice.getAll(employee);
	
	}
	
	@PutMapping("/updateemployee/{id}")
	public Employee updateemployee(Employee employee)
	{
		return employeeservice.updateemployee(employee);
	}
	

}
