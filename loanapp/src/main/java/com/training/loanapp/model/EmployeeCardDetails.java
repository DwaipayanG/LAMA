package com.training.loanapp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.util.Date;

import jakarta.persistence.Column;

@Entity
@Table(name = "employee_card_details")
public class EmployeeCardDetails {
	@Id
	@Column(name = "employee_id", length=6)
	private String eMPLOYEEiD;
	@Column(name="loan_id", length=6)
	private String lOANiD;
	@Column(name="card_issue_date")
	private Date cARDiSSUEdATE;
	public String geteMPLOYEEiD() {
		return eMPLOYEEiD;
	}
	public void seteMPLOYEEiD(String eMPLOYEEiD) {
		this.eMPLOYEEiD = eMPLOYEEiD;
	}
	public String getlOANiD() {
		return lOANiD;
	}
	public void setlOANiD(String lOANiD) {
		this.lOANiD = lOANiD;
	}
	public Date getcARDiSSUEdATE() {
		return cARDiSSUEdATE;
	}
	public void setcARDiSSUEdATE(Date cARDiSSUEdATE) {
		this.cARDiSSUEdATE = cARDiSSUEdATE;
	}
	
	
	
	

}
