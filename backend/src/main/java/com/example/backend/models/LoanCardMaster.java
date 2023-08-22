package com.example.backend.models;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="loanCardMaster",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonManagedReference(value="loanCard")
	private List<EmployeeCardDetails> employeeCardDetails;
	
	public List<EmployeeCardDetails> getEmployeeCardDetails() {
		return employeeCardDetails;
	}

	public void setEmployeeCardDetails(List<EmployeeCardDetails> employeeCardDetails) {
		this.employeeCardDetails = employeeCardDetails;
	}

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
