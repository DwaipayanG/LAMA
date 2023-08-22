package com.example.backend.services;

import java.util.List;
import java.util.Optional;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.EmployeeMaster;

public interface EmployeeMasterService {
	
	public List<EmployeeMaster> getAllEmployees();
	
	public EmployeeMaster addEmployeeMaster (EmployeeMaster employeeInstance);
	
	public Optional<EmployeeMaster> updateEmployeeMaster (EmployeeMaster employeeInstance);
	
	public EmployeeMaster getEmployeeMasterById (String employeeId) throws ResourceNotFoundException;
	
	public void deleteEmployeeMasterById(String employeeId) throws ResourceNotFoundException;
	
	public EmployeeMaster updateEmployee(EmployeeMaster employeeMaster,EmployeeMaster newEmployeeMaster);
	
	public boolean deleteEmployeeMaster(String employeeId) throws ResourceNotFoundException;

}
