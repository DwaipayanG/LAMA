package com.example.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.LoanCardMasterRepository;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.LoanCardMaster;

@Service
public class LoanCardMasterServiceImpl implements LoanCardMasterService{
	
	@Autowired
	private LoanCardMasterRepository loanCardMasterRepo;
	
	public LoanCardMaster getLoanCardByLoanType(String loanType) throws ResourceNotFoundException{
		LoanCardMaster loanCard = loanCardMasterRepo.findLoanCardByLoanType(loanType);
		if(loanCard == null) {
			throw new ResourceNotFoundException("No loan card exists of tthis loan type");
		}else {
			return loanCard;
		}
	}
	
	public LoanCardMaster addLoanCard(LoanCardMaster loanCard) {
		return loanCardMasterRepo.save(loanCard);
	}
	
	public LoanCardMaster getLoanCardById(String id) throws ResourceNotFoundException{
		LoanCardMaster loanCard = loanCardMasterRepo.findById(id).orElse(null);
		if(loanCard == null) {
			throw new ResourceNotFoundException("Loan card not found");
		}else {
			return loanCard;
		}
	}
	
	public List<String> getAllLoanTypes(){
		return loanCardMasterRepo.getAllLoanTypes();
	}
	
	public LoanCardMaster updateLoanCard(LoanCardMaster loanCardMaster, LoanCardMaster newLoanCardMaster) {
		loanCardMaster.setDurationInYears(newLoanCardMaster.getDurationInYears());
		loanCardMasterRepo.save(loanCardMaster);
		return loanCardMaster;
	}
	
	public void deleteLoanCard(String id) {
		loanCardMasterRepo.deleteById(id);
	}
	
	public List<LoanCardMaster> getAllLoanCards(){
		return loanCardMasterRepo.findAll();
	}
}
