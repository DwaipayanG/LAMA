package com.example.backend.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="employee_card_details")
public class EmployeeCardDetails{
	
	@Id
	@Column(name="card_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cardId;
	

	@Column(name="card_issue_date", nullable = false)
	
	private Date cardIssueDate;
	
	
	@ManyToOne
	@JoinColumn(name = "loan_id",nullable=false)
	@JsonBackReference(value="loanCard")
	private LoanCardMaster loanCardMaster;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	@JsonBackReference(value="employeeCard")
	private EmployeeMaster employeeMaster;
	
	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}

	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}



	public Date getCardIssueDate() {
		return cardIssueDate;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}

	public LoanCardMaster getLoanCardMaster() {
		return loanCardMaster;
	}

	public void setLoanCardMaster(LoanCardMaster loanCardMaster) {
		this.loanCardMaster = loanCardMaster;
	}
	
	
	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	

}
