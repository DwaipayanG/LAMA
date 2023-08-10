package com.training.loanapp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

import jakarta.persistence.Column;

@Entity
@Table(name = "employee_issue_details")
public class EmployeeIssueDetails {
	@Id
	@Column(name = "issue_id", length=6)
	private String iSSUEiD;
	@Column(name = "employee_id", length=6)
	private String eMPLOYEEiD;
	@Column(name="item_id", length=6)
	private String iTEMiD;
	@Column(name="issue_date")
	private Date iSSUEdATE;
	@Column(name="return_date")
	private Date rETURNdATE;
	public String getiSSUEiD() {
		return iSSUEiD;
	}
	public void setiSSUEiD(String iSSUEiD) {
		this.iSSUEiD = iSSUEiD;
	}
	public String geteMPLOYEEiD() {
		return eMPLOYEEiD;
	}
	public void seteMPLOYEEiD(String eMPLOYEEiD) {
		this.eMPLOYEEiD = eMPLOYEEiD;
	}
	public String getiTEMiD() {
		return iTEMiD;
	}
	public void setiTEMiD(String iTEMiD) {
		this.iTEMiD = iTEMiD;
	}
	public Date getiSSUEdATE() {
		return iSSUEdATE;
	}
	public void setiSSUEdATE(Date iSSUEdATE) {
		this.iSSUEdATE = iSSUEdATE;
	}
	public Date getrETURNdATE() {
		return rETURNdATE;
	}
	public void setrETURNdATE(Date rETURNdATE) {
		this.rETURNdATE = rETURNdATE;
	}
	
	
	
	

}
