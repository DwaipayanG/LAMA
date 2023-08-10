package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.EmployeeMasterRepository;
import com.example.backend.models.EmployeeMaster;

@Service
public class EmployeeMasterService {
	
	@Autowired
	private EmployeeMasterRepository employeeRepo;
	
	public EmployeeMaster addEmployeeMaster (EmployeeMaster employeeInstance) {
		
		return employeeRepo.save(employeeInstance);
		
	}
}
