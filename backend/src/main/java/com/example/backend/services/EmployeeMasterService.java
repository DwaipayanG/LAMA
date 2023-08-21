package com.example.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.EmployeeMasterRepository;
import com.example.backend.exception.AuthenticationException;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.EmployeeMaster;

@Service
public class EmployeeMasterService {
	
	@Autowired
	private EmployeeMasterRepository employeeRepo;
	
	public List<EmployeeMaster> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
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
	
	public EmployeeMaster getEmployeeMasterById (String employeeId) throws ResourceNotFoundException{
		
		EmployeeMaster existingEmployeeInstance = employeeRepo.findById(employeeId).orElse(null);
		if(existingEmployeeInstance == null)
			throw new ResourceNotFoundException("Employee not found!");
		else 
			return existingEmployeeInstance;
	}
	
	public void deleteEmployeeMasterById(String employeeId) throws ResourceNotFoundException {
		try {
			employeeRepo.deleteById(employeeId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Employee does not exist!");
		}
	}
	
	public EmployeeMaster updateEmployee(EmployeeMaster employeeMaster,EmployeeMaster newEmployeeMaster) {
		employeeMaster.setEmployeeName(newEmployeeMaster.getEmployeeName());
		employeeMaster.setDepartment(newEmployeeMaster.getDepartment());
		employeeMaster.setDesignation(newEmployeeMaster.getDesignation());
		employeeMaster.setGender(newEmployeeMaster.getGender());
		employeeMaster.setDateOfBirth(newEmployeeMaster.getDateOfBirth());
		employeeMaster.setDateOfJoining(newEmployeeMaster.getDateOfJoining());
		return employeeMaster;
	}
	
	public boolean deleteEmployeeMaster(String employeeId) throws ResourceNotFoundException {
		
		Optional<EmployeeMaster> existingEmployeeInstance = employeeRepo.findById(employeeId);
		
		if(existingEmployeeInstance.isPresent()) {
			employeeRepo.delete(existingEmployeeInstance.get());
			return true;
		}else {
			throw new ResourceNotFoundException("Employee doest not exist!");
		}
	}
}
