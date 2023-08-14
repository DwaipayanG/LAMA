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
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EmployeeLoanId.class)
public class EmployeeCardDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3750002964740346087L;

	@Id
	@Column(name="employee_id", nullable=false, length=6)
	private String employeeId;
	
	@Id
	@Column(name="loan_id", nullable=false, length=6)
	private String loanId;
	
	@Column(name="card_issue_date")
	private Date cardIssueDate;
	
	private LoanCardMaster loanCardMaster;
	@ManyToOne
	@JoinColumn(name = "loan_id")
	
	private EmployeeMaster employeeMaster;
	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}

	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}

	@ManyToOne
	@JoinColumn(name = "employee_id")


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

	public LoanCardMaster getLoanCardMaster() {
		return loanCardMaster;
	}

	public void setLoanCardMaster(LoanCardMaster loanCardMaster) {
		this.loanCardMaster = loanCardMaster;
	}
	
	
	
	

}
