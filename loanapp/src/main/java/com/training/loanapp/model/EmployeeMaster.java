package com.training.loanapp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

import jakarta.persistence.Column;

@Entity
@Table(name = "employee_master")
public class EmployeeMaster {
	@Id
	@Column(name = "employee_id", length=6)
	private String eMPLOYEEiD;
	@Column(name = "employee_name", length=20)
	private String eMPLOYEEnAME;
	@Column(name="designation", length=25)
	private String dESIGNATION;
	@Column(name="department", length=25)
	private String dEPARTMENT;
	@Column(name="gender", length=1)
	private String gENDER;
	@Column(name="date_of_birth")
	private Date dATEoFbIRTH;
	@Column(name="date_of_joining")
	private Date dATEoFjOINING;
	public String geteMPLOYEEiD() {
		return eMPLOYEEiD;
	}
	public void seteMPLOYEEiD(String eMPLOYEEiD) {
		this.eMPLOYEEiD = eMPLOYEEiD;
	}
	public String geteMPLOYEEnAME() {
		return eMPLOYEEnAME;
	}
	public void seteMPLOYEEnAME(String eMPLOYEEnAME) {
		this.eMPLOYEEnAME = eMPLOYEEnAME;
	}
	public String getdESIGNATION() {
		return dESIGNATION;
	}
	public void setdESIGNATION(String dESIGNATION) {
		this.dESIGNATION = dESIGNATION;
	}
	public String getdEPARTMENT() {
		return dEPARTMENT;
	}
	public void setdEPARTMENT(String dEPARTMENT) {
		this.dEPARTMENT = dEPARTMENT;
	}
	public String getgENDER() {
		return gENDER;
	}
	public void setgENDER(String gENDER) {
		this.gENDER = gENDER;
	}
	public Date getdATEoFbIRTH() {
		return dATEoFbIRTH;
	}
	public void setdATEoFbIRTH(Date dATEoFbIRTH) {
		this.dATEoFbIRTH = dATEoFbIRTH;
	}
	public Date getdATEoFjOINING() {
		return dATEoFjOINING;
	}
	public void setdATEoFjOINING(Date dATEoFjOINING) {
		this.dATEoFjOINING = dATEoFjOINING;
	}
	
	
	

}
