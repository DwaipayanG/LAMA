package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exception.DataUnavailableException;
import com.example.backend.exception.DuplicateEntryException;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.LoanCardMaster;
import com.example.backend.services.LoanCardMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoanCardMasterController {
	
	@Autowired
	private LoanCardMasterService loanCardMasterService;
	
	@GetMapping("/getAllLoanCards")
	public List<LoanCardMaster> getAllLoanCard() throws DataUnavailableException{
		
		List<LoanCardMaster> loanCards =  loanCardMasterService.getAllLoanCards();
		if(loanCards.size()==0)
			throw new DataUnavailableException("No Loan Cards present");
		else
			return loanCards;
	}
	
	@PostMapping("/addLoanCard")
	public LoanCardMaster addLoanCard(@RequestBody LoanCardMaster loanCard) throws DuplicateEntryException {
		try {
			LoanCardMaster loanCardMaster = this.getLoanCardById(loanCard.getLoanId());
			throw new DuplicateEntryException("Loan card already exists!");
		} catch (ResourceNotFoundException e) {
			// TODO: handle exception
			return loanCardMasterService.addLoanCard(loanCard);
		}
	}
	
	@GetMapping("/deleteLoanCard")
	public String deleteLoanCard(@RequestParam String loanId) {
		loanCardMasterService.deleteLoanCard(loanId);
		return "deleted";
	}
	
	@PutMapping("/updateLoanCard")
	public LoanCardMaster updateLoanCard(@RequestParam String loanId, @RequestBody LoanCardMaster newLoanCardMaster) throws ResourceNotFoundException {
		LoanCardMaster loanCardMaster = loanCardMasterService.getLoanCardById(loanId);
		loanCardMaster = loanCardMasterService.updateLoanCard(loanCardMaster, newLoanCardMaster);
		return loanCardMaster;
	}
	
	@GetMapping("/getLoanCardByLoanType")
	@ResponseBody
	public LoanCardMaster getLoanCardByLoanType(@RequestParam("loanType") String loanType) throws ResourceNotFoundException {
		return loanCardMasterService.getLoanCardByLoanType(loanType);
	}
	
	@GetMapping("/getLoanCardById")
	public LoanCardMaster getLoanCardById(@RequestParam("loanId") String loanId) throws ResourceNotFoundException {
		return loanCardMasterService.getLoanCardById(loanId);
	}
}
