package com.example.backend.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeMasterLoginDTO {
	
	private String employeeId;
	private String password;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
