package com.example.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="loan_card_master")
public class LoanCardMaster {
	@Id
	@Column(name="loan_id", nullable=false, length=6)
	private String loanId;
	
	@Column(name="loan_type", length=15)
	private String loanType;
	
	@Column(name="duration_in_years")
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
