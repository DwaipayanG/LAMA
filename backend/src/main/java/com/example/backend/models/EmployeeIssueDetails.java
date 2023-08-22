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

@Entity
@Table(name="employee_issue_details")
public class EmployeeIssueDetails {
	@Id
	@Column(name="issue_id", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int issueId;
	
	
	@Column(name="issue_date")
	private Date issueDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	@JsonBackReference(value="itemIssue")
	private ItemsMaster itemsMaster;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	@JsonBackReference(value="employeeIssue")
	private EmployeeMaster employeeMaster;
	
	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}


	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public ItemsMaster getItemsMaster() {
		return itemsMaster;
	}

	public void setItemsMaster(ItemsMaster itemsMaster) {
		this.itemsMaster = itemsMaster;
	}

	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}

	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}
	
	
	
}
