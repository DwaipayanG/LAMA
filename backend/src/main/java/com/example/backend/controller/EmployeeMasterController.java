package com.example.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.ApplyLoanData;
import com.example.backend.models.EmployeeIssueDetails;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.EmployeeMasterLogin;
import com.example.backend.services.EmployeeCardDetailsService;
import com.example.backend.services.EmployeeIssueDetailsService;
import com.example.backend.services.EmployeeMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeMasterController {
	@Autowired 
	private EmployeeMasterService employeeMasterService;
		
	@Autowired
	private EmployeeCardDetailsService employeeCardDetailsService;
	
	@Autowired
	private EmployeeIssueDetailsService employeeIssueDetailsService;
	
	@GetMapping("/getAllEmployees")
	public List<EmployeeMaster> getAllEmployees(){
		return employeeMasterService.getAllEmployees();
	}
	
	@GetMapping("/getEmployeeById")
	public EmployeeMaster getEmployeeMaster(@RequestParam("employeeId") String employeeId) {
		return employeeMasterService.getEmployeeMasterById(employeeId).get();
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployeeById(@RequestParam String employeeId) {
		employeeMasterService.deleteEmployeeMasterById(employeeId);
		return "deleted";
	}
	
	@PostMapping("/addEmployee")
	public EmployeeMaster addEmployeeMaster(@RequestBody EmployeeMaster newEmployee)
	{
		EmployeeMaster employee = employeeMasterService.addEmployeeMaster(newEmployee);
		return employee;
	}
	
	@PostMapping("/loginEmployee")
	@ResponseBody
	public Object loginEmployeeMaster(@RequestBody EmployeeMasterLogin empLogin) {
		Object response;
		Optional<EmployeeMaster> existingEmployee = employeeMasterService.getEmployeeMasterById(empLogin.getEmployeeId());
		if(existingEmployee.isPresent()) {
			if(existingEmployee.get().getPassword().equals(empLogin.getPassword())) {
				response = existingEmployee.get();
			}else {
				response = new String("Wrong password");
			}
		}else {
			response = new String("Invalid employee ID");
		}
		return response;
	}
	
	@PostMapping("/applyLoan")
	public Object applyLoan(@RequestBody ApplyLoanData loanData) {

		EmployeeMaster employeeMaster = employeeMasterService.getEmployeeMasterById(loanData.getEmployeeId()).get(); 
				
		Date loanReturnDate = employeeCardDetailsService.addEmployeeCardDetailsToGetLoanReturnDate(loanData.getLoanId(), loanData.getLoanIssueDate(), employeeMaster);
		
		EmployeeIssueDetails employeeIssueDetails = employeeIssueDetailsService.addEmployeeIssueDetails(loanData.getItemId(), loanData.getLoanIssueDate(), loanReturnDate, employeeMaster);
		
		Object response = new String("Loan applied");
		
		return response;
		
	}

}
