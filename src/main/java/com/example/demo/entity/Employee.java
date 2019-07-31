package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	private String employeeName;
	private String employeeAdress;
	private Long  employeeMobileNumber;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(Long employeeId, String employeeName, String employeeAdress, Long employeeMobileNumber) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAdress = employeeAdress;
		this.employeeMobileNumber = employeeMobileNumber;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAdress() {
		return employeeAdress;
	}
	public void setEmployeeAdress(String employeeAdress) {
		this.employeeAdress = employeeAdress;
	}
	public Long getEmployeeMobileNumber() {
		return employeeMobileNumber;
	}
	public void setEmployeeMobileNumber(Long employeeMobileNumber) {
		this.employeeMobileNumber = employeeMobileNumber;
	}
	
	
}
