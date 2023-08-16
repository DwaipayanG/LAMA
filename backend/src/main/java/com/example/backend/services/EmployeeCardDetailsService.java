package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.EmployeeCardDetailsRepository;
import com.example.backend.models.EmployeeCardDetails;

@Service
public class EmployeeCardDetailsService {
	
	@Autowired
	private EmployeeCardDetailsRepository employeeCardDetailsRepo;
	
	public EmployeeCardDetails addEmployeeCardDetails(EmployeeCardDetails employeeCardDetails) {
		return employeeCardDetailsRepo.save(employeeCardDetails);
	}
}
