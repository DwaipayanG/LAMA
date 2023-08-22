package com.example.backend.services;

import java.util.Date;
import java.util.List;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.EmployeeCardDetails;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.ViewLoans;

public interface EmployeeCardDetailsService {
	
	public EmployeeCardDetails addEmployeeCardDetails(EmployeeCardDetails employeeCardDetails);
	
	public Date getLoanReturnDate(Date loanIssueDate, int durationInYears);
	
	public Date addEmployeeCardDetailsToGetLoanReturnDate(String loanId, Date loanIssueDate, EmployeeMaster employeeMaster) throws ResourceNotFoundException;
	
	public List<ViewLoans> getAllLoans(String employeeId);
	
	

}
