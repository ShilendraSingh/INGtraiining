package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {

	@Mock
	EmployeeService employeeservice;
	
	@InjectMocks
	EmployeeController employeeController;
	
	private MockMvc mockMvc;
	Employee emp;
	
	
	@Before
	public void Setup()
	{
		emp=new Employee(1000l, "Shalendra", "Varanasi", 68723648l);
		mockMvc=MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	
	public static String asJsonObject(final Object obj) {
		try
		{
			return new ObjectMapper().writeValueAsString(obj);
			
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		
	} 
	
	
	@Test
	public void testSaveemployee() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/Employee/saveemployee").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonObject(emp))).andExpect(status().isOk());
		assertEquals("Shalendra", employeeController.saveemployee(emp));
	}
	@Test
	public void testSaveemployee1() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/Employee/getemployee/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonObject(emp))).andExpect(status().isOk());
		assertEquals("Shalendra", employeeController.getallEmployee(emp));
	}
	@Test
	public void testSaveemployee2() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/Employee/deleteemployee/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonObject(emp))).andExpect(status().isOk());
		//assertEquals("Shalendra", employeeController.deleteEmployee(1l));
	}
	
	@Test
	public void testSaveemployee3() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/Employee/getAllemployee").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonObject(emp))).andExpect(status().isOk());
		assertEquals("Shalendra", employeeController.getallEmployee(emp));
	}
	
	@Test
	public void testSaveemployee4() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.put("/Employee/updateemployee/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonObject(emp))).andExpect(status().isOk());
		assertEquals("Shalendra", employeeController.updateemployee(emp));
	}
}
