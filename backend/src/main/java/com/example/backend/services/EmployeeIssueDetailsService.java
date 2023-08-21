package com.example.backend.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.EmployeeIssueDetailsRepository;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.EmployeeIssueDetails;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.ItemsMaster;
import com.example.backend.models.ViewItems;

@Service
public class EmployeeIssueDetailsService {

		@Autowired
		private EmployeeIssueDetailsRepository employeeIssueDetailsRepo;
		
		@Autowired
		private ItemsMasterService itemsMasterService;
		
		public EmployeeIssueDetails addEmployeeIssueDetails(EmployeeIssueDetails employeeIssueDetails) {
			return employeeIssueDetailsRepo.save(employeeIssueDetails);
		}
		
		public EmployeeIssueDetails addEmployeeIssueDetails(String itemId, Date loanIssueDate, Date loanReturnDate, EmployeeMaster employeeMaster) throws ResourceNotFoundException {
			ItemsMaster itemMaster = itemsMasterService.getItemById(itemId);
			
			EmployeeIssueDetails employeeIssueDetails = new EmployeeIssueDetails();
			employeeIssueDetails.setIssueDate(loanIssueDate);
			employeeIssueDetails.setReturnDate(loanReturnDate);
			employeeIssueDetails.setItemsMaster(itemMaster);
			employeeIssueDetails.setEmployeeMaster(employeeMaster);
			
			return this.addEmployeeIssueDetails(employeeIssueDetails);
			
		}
		
		public List<ViewItems> getAllItems(String employeeId){
			List<Object[]> items =  employeeIssueDetailsRepo.getItemsByEmployeeId(employeeId);
			List<ViewItems> response = new ArrayList<ViewItems>();
			
			for (Object[] item : items) {
				ViewItems currItem = new ViewItems();
				
				currItem.setIssueId((int)item[0]);
				currItem.setItemDescription((String)item[1]);
				currItem.setItemMake((String)item[2]);
				currItem.setItemCategory((String)item[3]);
				currItem.setItemValuation((int)item[4]);
				
				response.add(currItem);
			}
			
			return response;
		}
}
