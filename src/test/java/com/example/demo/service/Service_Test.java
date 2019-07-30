package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;

@RunWith(MockitoJUnitRunner.class)
public class Service_Test {
	
	@InjectMocks
	EmployeeImpl employeeImpl;
	
	 @Mock
	EmployeeRepo employeerepo;
	 
	 Employee emp;


	  @Before
	 public void setData()
		{
			emp= new Employee(1000l, "Shalendra", "Varanasi", 68723648l);
		}
	
	  @Test
		public void getEmployeeByIdTest_P()
		{
			
			Mockito.when(employeerepo.findById(Mockito.anyLong())).thenReturn(Optional.of(emp));
			
			Employee employee = employeeImpl.getById(1000l);
			assertEquals("Shalendra", employee.getEmployeeName());
		}

	  @Test
		public void updateEmployeeTest()
		{
			Mockito.when(employeerepo.findById(Mockito.anyLong())).thenReturn(Optional.of(emp));
			Mockito.when(employeerepo.save(Mockito.any())).thenReturn(emp);
			
			Employee employee = employeeImpl.updateemployee(emp)	;		
			assertEquals(employee, employee);
		}
	  @Test
		public void getAllEmployeesTest()
		{
			List<Employee> list = new ArrayList<>();
			list.add(emp);
			Mockito.when(employeerepo.findAll()).thenReturn((list));
			List<Employee> emp_list = employeeImpl.getAll(emp);
			assertEquals(1, emp_list.size());
		}
	  
	  @Test
		public void addEmployeeTest()
		{
			Mockito.when(employeerepo.save(Mockito.any())).thenReturn(emp);
			
			Employee employee = employeeImpl.save(emp);
			
			assertEquals(emp.getEmployeeName(), employee.getEmployeeName());
		}
}