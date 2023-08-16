package com.example.backend.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dao.EmployeeCardDetailsRepository;
import com.example.backend.dao.LoanCardMasterRepository;
import com.example.backend.models.EmployeeCardDetails;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.EmployeeMasterLogin;
import com.example.backend.models.LoanCardMaster;
import com.example.backend.services.EmployeeCardDetailsService;
import com.example.backend.services.EmployeeMasterService;
import com.example.backend.services.LoanCardMasterService;


class ApplyLoanData{
	public String loanId;
	public String employeeId;
};

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeMasterController {
	@Autowired 
	private EmployeeMasterService employeeMasterService;
	

	@Autowired
	private LoanCardMasterService loanCardMasterService;
	
	@Autowired
	private EmployeeCardDetailsService employeeCardDetailsService;
	
	@GetMapping("/getEmployee")
	public Optional<EmployeeMaster> getEmployeeMaster(@RequestBody EmployeeMaster employee) {
		return employeeMasterService.getEmployeeMasterById(employee.getEmployeeId());
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
	public void applyLoan(@RequestBody ApplyLoanData loanData) {
//		String loanId = employeeCardDetails.get
		LoanCardMaster loanCardMaster = loanCardMasterService.getLoanCardById(loanData.loanId);
		EmployeeMaster employeeMaster = employeeMasterService.getEmployeeMasterById(loanData.employeeId).get(); 
		
//		LoanCardMaster loanCard=new LoanCardMaster();
//		loanCard.setLoanId("123456");
//		loanCard.setLoanType("0123456789abcde");
//		loanCard.setDurationInYears(1);
		
		EmployeeCardDetails employeeCardDetails = new EmployeeCardDetails(); 
		List<EmployeeCardDetails> l = new ArrayList<EmployeeCardDetails>();
		l.add(employeeCardDetails);
		
		loanCardMaster.setEmployeeCardDetails(l);
		employeeMaster.setEmployeeCardDetails(l);
		employeeCardDetails.setLoanCardMaster(loanCardMaster);
		employeeCardDetails.setEmployeeMaster(employeeMaster);
		
		loanCardMasterService.addLoanCard(loanCardMaster);
		employeeCardDetailsService.addEmployeeCardDetails(employeeCardDetails);
		employeeMasterService.addEmployeeMaster(employeeMaster);
		
	}

}
