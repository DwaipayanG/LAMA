package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.EmployeeCardDetails;
import com.example.backend.models.ViewItems;
import com.example.backend.models.ViewLoans;
import com.example.backend.services.EmployeeCardDetailsServiceImpl;
import com.example.backend.services.EmployeeIssueDetailsServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeCardDetailsController {

		@Autowired
		private EmployeeCardDetailsServiceImpl employeeCardDetailsService;
		
		@Autowired
		private EmployeeIssueDetailsServiceImpl employeeIssueDetailsService;
		
		@PostMapping("/addEmployeeCardDetails")
		@ResponseBody
		public EmployeeCardDetails addEmployeeCardDetails(EmployeeCardDetails employeeCardDetails) {
			return employeeCardDetailsService.addEmployeeCardDetails(employeeCardDetails);
		}
		
		@GetMapping("/getAllLoans")
		public List<ViewLoans> getAllLoans(@RequestParam("employeeId") String employeeId) {
			return employeeCardDetailsService.getAllLoans(employeeId);
		}
		
		@GetMapping("/getAllItems")
		public List<ViewItems> getAllItems(@RequestParam("employeeId") String employeeId) {
			return employeeIssueDetailsService.getAllItems(employeeId);
		}
		
}
