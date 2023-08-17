package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.EmployeeCardDetails;
import com.example.backend.services.EmployeeCardDetailsService;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeCardDetailsController {

		@Autowired
		private EmployeeCardDetailsService employeeCardDetailsService;
		
		@PostMapping("/addEmployeeCardDetails")
		@ResponseBody
		public EmployeeCardDetails addEmployeeCardDetails(EmployeeCardDetails employeeCardDetails) {
			return employeeCardDetailsService.addEmployeeCardDetails(employeeCardDetails);
		}
		
}
