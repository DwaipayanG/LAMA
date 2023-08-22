package com.example.backend.services;

import java.util.Date;
import java.util.List;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.EmployeeIssueDetails;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.ViewItems;

public interface EmployeeIssueDetailsService {
	
	public EmployeeIssueDetails addEmployeeIssueDetails(EmployeeIssueDetails employeeIssueDetails);
	
	public EmployeeIssueDetails addEmployeeIssueDetails(String itemId, Date loanIssueDate, Date loanReturnDate, EmployeeMaster employeeMaster) throws ResourceNotFoundException;
	
	public List<ViewItems> getAllItems(String employeeId);
	
	

}
