package com.example.backend.dto;

public class LoanCardMasterDTO {
	
	private String loanId;
	private String loanType;
	private int durationInYears;
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public int getDurationInYears() {
		return durationInYears;
	}
	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}
	
	
}
