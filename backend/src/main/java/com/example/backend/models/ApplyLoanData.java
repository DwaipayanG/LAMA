package com.example.backend.models;

import java.util.Date;

public class ApplyLoanData {
	
	private String loanId;
	private String employeeId;
	private String itemId;
	private Date loanIssueDate;
	
	public Date getLoanIssueDate() {
		return loanIssueDate;
	}
	public void setLoanIssueDate(Date loanIssueDate) {
		this.loanIssueDate = loanIssueDate;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	

}
