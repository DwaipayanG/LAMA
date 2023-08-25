package com.example.backend.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.ViewItemsDTO;
import com.example.backend.dto.ViewLoansDTO;
import com.example.backend.models.EmployeeCardDetails;
import com.example.backend.models.ViewItems;
import com.example.backend.models.ViewLoans;
import com.example.backend.services.EmployeeCardDetailsServiceImpl;
import com.example.backend.services.EmployeeIssueDetailsServiceImpl;

import jakarta.validation.Valid;

@RestController
@Validated
@CrossOrigin("http://localhost:3000")
public class EmployeeCardDetailsController {

		@Autowired
		private EmployeeCardDetailsServiceImpl employeeCardDetailsService;
		
		@Autowired
		private EmployeeIssueDetailsServiceImpl employeeIssueDetailsService;
		
		@Autowired
		private ModelMapper ModelMap;
				
		@GetMapping("/api/employee-card/all-loans-by-employee-id")
		public List<ViewLoansDTO> getAllLoans(@Valid @RequestParam("employeeId") String employeeId) {
			return employeeCardDetailsService.getAllLoans(employeeId).stream().map(loan->ModelMap.map(loan, ViewLoansDTO.class)).collect(Collectors.toList());
		}
		
		@GetMapping("/api/employee-card/all-items-by-employee-id")
		public List<ViewItemsDTO> getAllItems(@Valid @RequestParam("employeeId") String employeeId) {
			return employeeIssueDetailsService.getAllItems(employeeId).stream().map(item->ModelMap.map(item,  ViewItemsDTO.class)).collect(Collectors.toList());
		}
		
}
