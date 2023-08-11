package com.example.backend.services;

import java.util.Optional;

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
	
	public Optional<EmployeeMaster> updateEmployeeMaster (EmployeeMaster employeeInstance){
		
		Optional<EmployeeMaster> existingEmployeeInstance = employeeRepo.findById(employeeInstance.getEmployeeId());
		
		if(existingEmployeeInstance.isPresent()) {
			employeeRepo.delete(existingEmployeeInstance.get());
			employeeRepo.save(employeeInstance);
		}
		
		return existingEmployeeInstance;
	}
	
	public Optional<EmployeeMaster> getEmployeeMasterById (String employeeId){
		
		Optional<EmployeeMaster> existingEmployeeInstance = employeeRepo.findById(employeeId);
				
		return existingEmployeeInstance;
	}
	
	public boolean deleteEmployeeMaster(String employeeId) {
		
		Optional<EmployeeMaster> existingEmployeeInstance = employeeRepo.findById(employeeId);
		
		if(existingEmployeeInstance.isPresent()) {
			employeeRepo.delete(existingEmployeeInstance.get());
			return true;
		}else {
			return false;
		}
	}
}
