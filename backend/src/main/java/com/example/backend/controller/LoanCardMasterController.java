package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.LoanCardMaster;
import com.example.backend.services.LoanCardMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoanCardMasterController {
	
	@Autowired
	private LoanCardMasterService loanCardMasterService;
	
	@PostMapping("/getLoanCardByLoanType")
	@ResponseBody
	public LoanCardMaster getLoanCardByLoanType(@RequestBody LoanCardMaster loanCard) {
		return loanCardMasterService.getLoanCardByLoanType(loanCard.getLoanType());
	}
}
