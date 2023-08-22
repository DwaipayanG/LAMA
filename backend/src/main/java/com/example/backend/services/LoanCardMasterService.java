package com.example.backend.services;

import java.util.List;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.LoanCardMaster;

public interface LoanCardMasterService {
	
	public LoanCardMaster getLoanCardByLoanType(String loanType) throws ResourceNotFoundException;
	
	public LoanCardMaster addLoanCard(LoanCardMaster loanCard);

	
	public LoanCardMaster getLoanCardById(String id) throws ResourceNotFoundException;
	
	public LoanCardMaster updateLoanCard(LoanCardMaster loanCardMaster, LoanCardMaster newLoanCardMaster);
	
	public void deleteLoanCard(String id);
	
	public List<LoanCardMaster> getAllLoanCards();
	
}
