package com.example.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exception.AuthenticationException;
import com.example.backend.exception.DataUnavailableException;
import com.example.backend.exception.DuplicateEntryException;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.ApplyLoanData;
import com.example.backend.models.EmployeeIssueDetails;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.EmployeeMasterLogin;
import com.example.backend.services.EmployeeCardDetailsServiceImpl;
import com.example.backend.services.EmployeeIssueDetailsServiceImpl;
import com.example.backend.services.EmployeeMasterServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeMasterController {
	@Autowired 
	private EmployeeMasterServiceImpl employeeMasterService;
		
	@Autowired
	private EmployeeCardDetailsServiceImpl employeeCardDetailsService;
	
	@Autowired
	private EmployeeIssueDetailsServiceImpl employeeIssueDetailsService;
	
	@GetMapping("/getAllEmployees")
	public List<EmployeeMaster> getAllEmployees() throws DataUnavailableException{
		List<EmployeeMaster> employees = employeeMasterService.getAllEmployees();
		if(employees.size() == 0)
			throw new DataUnavailableException("No Employees found.");
		else
			return employees;
	}
	
	@GetMapping("/getEmployeeById")
	public EmployeeMaster getEmployeeMaster(@RequestParam("employeeId") String employeeId) throws ResourceNotFoundException {
		EmployeeMaster employeeMaster = employeeMasterService.getEmployeeMasterById(employeeId);
		if(employeeMaster == null)
			throw new ResourceNotFoundException("Employee Id not found");
		else 
			return employeeMaster;
	}
	
	@PutMapping("/updateEmployee")
	public EmployeeMaster updateEmployeeMaster(@RequestParam String employeeId,@RequestBody EmployeeMaster newEmployeeMaster) throws ResourceNotFoundException {
		EmployeeMaster employeeMaster = employeeMasterService.getEmployeeMasterById(employeeId);
		employeeMaster = employeeMasterService.updateEmployee(employeeMaster, newEmployeeMaster);
		employeeMasterService.addEmployeeMaster(employeeMaster);
		return employeeMaster;
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployeeById(@RequestParam String employeeId) throws ResourceNotFoundException {
		EmployeeMaster employeeMaster = this.getEmployeeMaster(employeeId);
		employeeMasterService.deleteEmployeeMasterById(employeeId);
		return "deleted";
	}
	
	@PostMapping("/addEmployee")
	public EmployeeMaster addEmployeeMaster(@RequestBody EmployeeMaster newEmployee) throws DuplicateEntryException 
	{
		try {
			EmployeeMaster employeeMaster = this.getEmployeeMaster(newEmployee.getEmployeeId());
			throw new DuplicateEntryException("Employee already exists!");
		} catch (ResourceNotFoundException e) {
			// TODO: handle exception
			EmployeeMaster employee = employeeMasterService.addEmployeeMaster(newEmployee);
			return employee;
		}
	}
	
	
	@PostMapping("/loginEmployee")
	@ResponseBody
	public Object loginEmployeeMaster(@RequestBody EmployeeMasterLogin empLogin) throws ResourceNotFoundException, AuthenticationException{
		Object response;
		EmployeeMaster existingEmployee = employeeMasterService.getEmployeeMasterById(empLogin.getEmployeeId());
		if(existingEmployee.getPassword().equals(empLogin.getPassword())) {
			response = existingEmployee;
		}else {
			throw new AuthenticationException("Authentication failed!");
		}
		return response;
	}
	
	@PostMapping("/applyLoan")
	public Object applyLoan(@RequestBody ApplyLoanData loanData) throws ResourceNotFoundException {

		EmployeeMaster employeeMaster = employeeMasterService.getEmployeeMasterById(loanData.getEmployeeId()); 
				
		Date loanReturnDate = employeeCardDetailsService.addEmployeeCardDetailsToGetLoanReturnDate(loanData.getLoanId(), loanData.getLoanIssueDate(), employeeMaster);
		
		EmployeeIssueDetails employeeIssueDetails = employeeIssueDetailsService.addEmployeeIssueDetails(loanData.getItemId(), loanData.getLoanIssueDate(), loanReturnDate, employeeMaster);
		
		Object response = new String("Loan applied");
		
		return response;
		
	}

}
