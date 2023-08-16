package com.example.backend.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee_card_details")
public class EmployeeCardDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3750002964740346087L;

	
	@Id
	@Column(name="card_id",nullable=false)
	private int cardId;
	
	@Column(name="card_issue_date")
	private Date cardIssueDate;
	
	
	@ManyToOne
	@JoinColumn(name = "loan_id",nullable=false)
	private LoanCardMaster loanCardMaster;
	
	@ManyToOne
	@JoinColumn(name = "employee_id",nullable=false)
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
	
	
	
	

}
