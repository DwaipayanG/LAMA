package com.example.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.EmployeeMasterLogin;
import com.example.backend.services.EmployeeMasterService;


@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeMasterController {
	@Autowired 
	private EmployeeMasterService employeeMasterService;
	
	@PostMapping("/addEmployee")
	public EmployeeMaster addEmployeeMaster(@RequestBody EmployeeMaster newEmployee)
	{
		EmployeeMaster employee = employeeMasterService.addEmployeeMaster(newEmployee);
		return employee;
	}
	
	@PostMapping("/loginEmployee")
	public String loginEmployeeMaster(@RequestBody EmployeeMasterLogin empLogin) {
		String response = "";
		Optional<EmployeeMaster> existingEmployee = employeeMasterService.getEmployeeMasterById(empLogin.getEmployeeId());
		if(existingEmployee.isPresent()) {
			if(existingEmployee.get().getPassword().equals(empLogin.getPassword())) {
				response = "Login successful";
			}else {
				response = "Wrong password";
			}
		}else {
			response = "Invalid employee ID";
		}
		return response;
	}

}
