package com.example.backend.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_card_details")
public class EmployeeCardDetails {
	@Id
	@Column(name="employee_id", nullable=false, length=6)
	private String employeeId;
	
	@Column(name="loan_id", nullable=false, length=6)
	private String loanId;
	
	@Column(name="card_issue_date")
	private Date cardIssueDate;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public Date getCardIssueDate() {
		return cardIssueDate;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}
	
	
	
	

}
