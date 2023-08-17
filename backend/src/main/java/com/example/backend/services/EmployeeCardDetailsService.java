package com.example.backend.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.EmployeeCardDetailsRepository;
import com.example.backend.models.EmployeeCardDetails;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.LoanCardMaster;
import com.example.backend.models.ViewLoans;

@Service
public class EmployeeCardDetailsService {
	
	@Autowired
	private EmployeeCardDetailsRepository employeeCardDetailsRepo;
	
	@Autowired
	private LoanCardMasterService loanCardMasterService;
	
	public EmployeeCardDetails addEmployeeCardDetails(EmployeeCardDetails employeeCardDetails) {
		return employeeCardDetailsRepo.save(employeeCardDetails);
	}
	
	public Date getLoanReturnDate(Date loanIssueDate, int durationInYears) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(loanIssueDate);
		
		cal.add(Calendar.YEAR, durationInYears);
		
		Date loanReturnDate = cal.getTime();
		
		return loanReturnDate;
	}
	
	public Date addEmployeeCardDetailsToGetLoanReturnDate(String loanId, Date loanIssueDate, EmployeeMaster employeeMaster) {
		LoanCardMaster loanCardMaster = loanCardMasterService.getLoanCardById(loanId);
		
		EmployeeCardDetails employeeCardDetails = new EmployeeCardDetails();
		
		employeeCardDetails.setEmployeeMaster(employeeMaster);
		employeeCardDetails.setLoanCardMaster(loanCardMaster);
		employeeCardDetails.setCardIssueDate(loanIssueDate);
		
		this.addEmployeeCardDetails(employeeCardDetails);
		
		return getLoanReturnDate(employeeCardDetails.getCardIssueDate(), loanCardMaster.getDurationInYears());
	}
	
	public List<ViewLoans> getAllLoans(String employeeId){
		List<Object[]> loans =  employeeCardDetailsRepo.getLoansByEmployeeId(employeeId);
		List<ViewLoans> response = new ArrayList<ViewLoans>();
		
		for (Object[] loan: loans) {
			ViewLoans currLoan = new ViewLoans();
			
			currLoan.setLoanId((String)loan[0]);
			currLoan.setLoanType((String)loan[1]);
			currLoan.setDurationInYears((int)loan[2]);
			currLoan.setCardIssueDate((Date)loan[3]);
			
			response.add(currLoan);
		}
		
		return response;
	}
}
