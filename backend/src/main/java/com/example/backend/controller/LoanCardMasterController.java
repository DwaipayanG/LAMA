package com.example.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.LoanCardMasterDTO;
import com.example.backend.exception.DataUnavailableException;
import com.example.backend.exception.DuplicateEntryException;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.LoanCardMaster;
import com.example.backend.services.LoanCardMasterServiceImpl;

import jakarta.validation.Valid;

@RestController
@Validated
@CrossOrigin("http://localhost:3000")
public class LoanCardMasterController {
	
	@Autowired
	private LoanCardMasterServiceImpl loanCardMasterService;
	
	@Autowired
	private ModelMapper ModelMap;
	
	@GetMapping("/api/loan-card/all-loans")
	public List<LoanCardMasterDTO> getAllLoanCard() throws DataUnavailableException{
		
		List<LoanCardMaster> loanCards =  loanCardMasterService.getAllLoanCards();
		if(loanCards.size()==0)
			throw new DataUnavailableException("No Loan Cards present");
		else
			return loanCards.stream().map(loanCard->ModelMap.map(loanCard, LoanCardMasterDTO.class)).collect(Collectors.toList());
	}
	
	@GetMapping("/api/loan-card/all-loan-types")
	public List<String> getAllLoanTypes(){
		return loanCardMasterService.getAllLoanTypes();
	}
	
	@PostMapping("/api/loan-card")
	public LoanCardMasterDTO addLoanCard(@Valid @RequestBody LoanCardMasterDTO loanCardDTO) throws DuplicateEntryException {
		LoanCardMaster loanCard = ModelMap.map(loanCardDTO, LoanCardMaster.class);
		try {
			LoanCardMaster loanCardMaster = ModelMap.map(this.getLoanCardById(loanCard.getLoanId()), LoanCardMaster.class);
			throw new DuplicateEntryException("Loan card already exists!");
		} catch (ResourceNotFoundException e) {
			// TODO: handle exception
			return ModelMap.map(loanCardMasterService.addLoanCard(loanCard), LoanCardMasterDTO.class);
		}
	}
	
	@DeleteMapping("/api/loan-card")
	public String deleteLoanCard(@Valid @RequestParam String loanId) {
		loanCardMasterService.deleteLoanCard(loanId);
		return "deleted";
	}
	
	@PutMapping("/api/loan-card")
	public LoanCardMasterDTO updateLoanCard(@Valid @RequestParam String loanId, @Valid @RequestBody LoanCardMasterDTO newLoanCardMasterDTO) throws ResourceNotFoundException {
		
		LoanCardMaster newLoanCardMaster = ModelMap.map(newLoanCardMasterDTO, LoanCardMaster.class);
		LoanCardMaster loanCardMaster = loanCardMasterService.getLoanCardById(loanId);
		loanCardMaster = loanCardMasterService.updateLoanCard(loanCardMaster, newLoanCardMaster);
		return ModelMap.map(loanCardMaster, LoanCardMasterDTO.class);
	}
	
	@GetMapping("/api/loan-card/by-loan-type")
	@ResponseBody
	public LoanCardMasterDTO getLoanCardByLoanType(@Valid @RequestParam("loanType") String loanType) throws ResourceNotFoundException {
		return ModelMap.map(loanCardMasterService.getLoanCardByLoanType(loanType), LoanCardMasterDTO.class);
	}
	
	@GetMapping("/api/loan-card/by-loan-id")
	public LoanCardMasterDTO getLoanCardById(@Valid @RequestParam("loanId") String loanId) throws ResourceNotFoundException {
		return ModelMap.map(loanCardMasterService.getLoanCardById(loanId), LoanCardMasterDTO.class);
	}
}
