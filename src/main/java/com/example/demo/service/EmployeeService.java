package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public Employee save(Employee employee);
	public Employee getById(Long id);
	public void deleteEmployee(Long id);
	public List<Employee> getAll(Employee employee);
	public Employee updateemployee(Employee employee);

}
