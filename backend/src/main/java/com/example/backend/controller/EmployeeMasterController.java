package com.example.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DuplicateKeyException;


import org.springframework.validation.annotation.Validated;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.EmployeeMasterDTO;
import com.example.backend.dto.EmployeeMasterLoginDTO;
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

import jakarta.validation.Valid;

@RestController
@Validated
@CrossOrigin("http://localhost:3000")
public class EmployeeMasterController {
	@Autowired 
	private EmployeeMasterServiceImpl employeeMasterService;
		
	@Autowired
	private EmployeeCardDetailsServiceImpl employeeCardDetailsService;
	
	@Autowired
	private EmployeeIssueDetailsServiceImpl employeeIssueDetailsService;
	
	@Autowired 
	private ModelMapper ModelMap;
	
	@GetMapping("/api/employee/all-employees")
	public List<EmployeeMasterDTO> getAllEmployees() throws DataUnavailableException{
		List<EmployeeMaster> employees = employeeMasterService.getAllEmployees();
		if(employees.size() == 0)
			throw new DataUnavailableException("No Employees found.");
		else
			return employees.stream().map(employee->ModelMap.map(employee, EmployeeMasterDTO.class)).collect(Collectors.toList());
	}
	
	@GetMapping("/api/employee/by-employee-id")
	public EmployeeMasterDTO getEmployeeMaster(@Valid @RequestParam("employeeId") String employeeId) throws ResourceNotFoundException {
		EmployeeMaster employeeMaster = employeeMasterService.getEmployeeMasterById(employeeId);
		if(employeeMaster == null)
			throw new ResourceNotFoundException("Employee Id not found");
		else 
			return ModelMap.map(employeeMaster,EmployeeMasterDTO.class);
	}
	
	@PutMapping("/api/employee")
	public EmployeeMasterDTO updateEmployeeMaster(@Valid @RequestParam String employeeId,@Valid @RequestBody EmployeeMasterDTO newEmployeeMaster) throws ResourceNotFoundException {

		EmployeeMaster employeeMaster = employeeMasterService.getEmployeeMasterById(employeeId);

		employeeMaster = employeeMasterService.updateEmployee(employeeMaster, ModelMap.map(newEmployeeMaster, EmployeeMaster.class));
		employeeMasterService.addEmployeeMaster(employeeMaster);
		return ModelMap.map(employeeMaster, EmployeeMasterDTO.class);
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployeeById(@Valid @RequestParam String employeeId) throws ResourceNotFoundException {
		EmployeeMaster employeeMaster = ModelMap.map(this.getEmployeeMaster(employeeId), EmployeeMaster.class);

		employeeMasterService.deleteEmployeeMasterById(employeeId);
		return "deleted";
	}
	
	@PostMapping("/api/employee")
	public EmployeeMasterDTO addEmployeeMaster(@Valid @RequestBody EmployeeMasterDTO newEmployeeDTO) throws DuplicateEntryException{
		try {
			EmployeeMasterDTO employeeMasterDTO = this.getEmployeeMaster(newEmployeeDTO.getEmployeeId());
			throw new DuplicateEntryException("Employee already exists!");
		} catch (ResourceNotFoundException e) {
			// TODO: handle exception
			EmployeeMaster employee = employeeMasterService.addEmployeeMaster(ModelMap.map(newEmployeeDTO, EmployeeMaster.class));
			return ModelMap.map(employee, EmployeeMasterDTO.class);
		}
	}
	
	
	@PostMapping("/api/employee/login")
	@ResponseBody
	public Object loginEmployeeMaster(@Valid @RequestBody EmployeeMasterLoginDTO empLoginDTO) throws ResourceNotFoundException, AuthenticationException{

		Object response;
		EmployeeMasterLogin empLogin = ModelMap.map(empLoginDTO, EmployeeMasterLogin.class);
		EmployeeMaster existingEmployee = employeeMasterService.getEmployeeMasterById(empLogin.getEmployeeId());
		if(existingEmployee.getPassword().equals(empLogin.getPassword())) {
			response = existingEmployee;
		}else {
			throw new AuthenticationException("Authentication failed!");
		}
		return response;
	}
	
	@Transactional
	@PostMapping("/api/employee/apply-loan")
	public Object applyLoan(@Valid @RequestBody ApplyLoanData loanData) throws ResourceNotFoundException {


		EmployeeMaster employeeMaster = employeeMasterService.getEmployeeMasterById(loanData.getEmployeeId()); 
				
		Date loanReturnDate = employeeCardDetailsService.addEmployeeCardDetailsToGetLoanReturnDate(loanData.getLoanId(), loanData.getLoanIssueDate(), employeeMaster);
		
		EmployeeIssueDetails employeeIssueDetails = employeeIssueDetailsService.addEmployeeIssueDetails(loanData.getItemId(), loanData.getLoanIssueDate(), loanReturnDate, employeeMaster);
		
		Object response = new String("Loan applied");
		
		return response;
		
	}

}
