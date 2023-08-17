package com.example.backend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.EmployeeIssueDetailsRepository;
import com.example.backend.models.EmployeeIssueDetails;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.ItemsMaster;

@Service
public class EmployeeIssueDetailsService {

		@Autowired
		private EmployeeIssueDetailsRepository employeeIssueDetailsRepo;
		
		@Autowired
		private ItemsMasterService itemsMasterService;
		
		public EmployeeIssueDetails addEmployeeIssueDetails(EmployeeIssueDetails employeeIssueDetails) {
			return employeeIssueDetailsRepo.save(employeeIssueDetails);
		}
		
		public EmployeeIssueDetails addEmployeeIssueDetails(String itemId, Date loanIssueDate, Date loanReturnDate, EmployeeMaster employeeMaster) {
			ItemsMaster itemMaster = itemsMasterService.getItemById(itemId);
			
			EmployeeIssueDetails employeeIssueDetails = new EmployeeIssueDetails();
			employeeIssueDetails.setIssueDate(loanIssueDate);
			employeeIssueDetails.setReturnDate(loanReturnDate);
			employeeIssueDetails.setItemsMaster(itemMaster);
			employeeIssueDetails.setEmployeeMaster(employeeMaster);
			
			return this.addEmployeeIssueDetails(employeeIssueDetails);
			
		}
}
