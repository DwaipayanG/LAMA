package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.LoanCardMasterRepository;
import com.example.backend.models.LoanCardMaster;

@Service
public class LoanCardMasterService {
	
	@Autowired
	private LoanCardMasterRepository loanCardMasterRepo;
	
	public LoanCardMaster getLoanCardByLoanType(String loanType) {
		return loanCardMasterRepo.findLoanCardByLoanType(loanType);
	}
	
	public LoanCardMaster addLoanCard(LoanCardMaster loanCard) {
		return loanCardMasterRepo.save(loanCard);
	}
	
	public LoanCardMaster getLoanCardById(String id) {
		return loanCardMasterRepo.findById(id).get();
	}
}
