package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;


@Service
public class EmployeeImpl implements EmployeeService {
	
	@Autowired
private EmployeeRepo employeerepo;

	@Override
	public Employee save(Employee employee) {
		return employeerepo.save(employee);
	
		
	}

	@Override
	public Employee getById(Long id) {
		Optional <Employee> emp=employeerepo.findById(id);
		if(!emp.isPresent())
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emp.get();
		
		
	}

	@Override
	public void deleteEmployee(@Valid Long id) {
	Optional<Employee> E4 = employeerepo.findById(id);
	if (E4.isPresent()) {
		
		employeerepo.deleteById(id);
	}
		
	
		
		
	}

	@Override
	public List<Employee> getAll(Employee employee) {
		return employeerepo.findAll();
	}

	@Override
	public Employee updateemployee(Employee employee) {
		Optional<Employee> findById = employeerepo.findById(employee.getEmployeeId());
		if (findById.isPresent()) {
			Employee newEmployee= findById.get();
			newEmployee.setEmployeeAdress(employee.getEmployeeAdress());
			newEmployee.setEmployeeMobileNumber(employee.getEmployeeMobileNumber());
			newEmployee.setEmployeeId(employee.getEmployeeId());
			newEmployee.setEmployeeName(employee.getEmployeeName());
			newEmployee=employeerepo.save(newEmployee);
			return newEmployee;
			
		}
		return employee ;
	}

	
		
	}

	

	

