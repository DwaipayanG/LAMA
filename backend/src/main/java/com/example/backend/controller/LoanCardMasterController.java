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

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.LoanCardMaster;
import com.example.backend.services.LoanCardMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoanCardMasterController {
	
	@Autowired
	private LoanCardMasterService loanCardMasterService;
	
	@GetMapping("/getAllLoanCards")
	public List<LoanCardMaster> getAllLoanCard(){
		return loanCardMasterService.getAllLoanCards();
	}
	
	@PostMapping("/addLoanCard")
	public LoanCardMaster addLoanCard(@RequestBody LoanCardMaster loanCard) {
		return loanCardMasterService.addLoanCard(loanCard);
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
	
	@PostMapping("/getLoanCardByLoanType")
	@ResponseBody
	public LoanCardMaster getLoanCardByLoanType(@RequestBody LoanCardMaster loanCard) throws ResourceNotFoundException {
		return loanCardMasterService.getLoanCardByLoanType(loanCard.getLoanType());
	}
	
	@GetMapping("/getLoanCardById")
	public LoanCardMaster getLoanCardById(@RequestParam("loanId") String loanId) throws ResourceNotFoundException {
		return loanCardMasterService.getLoanCardById(loanId);
	}
}
