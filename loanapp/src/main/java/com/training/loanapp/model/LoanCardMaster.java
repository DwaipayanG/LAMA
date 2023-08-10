package com.training.loanapp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "loan_card_master")
public class LoanCardMaster {
	@Id
	@Column(name = "loan_id", length=6)
	private String lOANiD;
	@Column(name="loan_type", length=15)
	private String lOANtYPE;
	@Column(name="duration_in_years")
	private int dURATIONiNyEARS;
	public String getlOANiD() {
		return lOANiD;
	}
	public void setlOANiD(String lOANiD) {
		this.lOANiD = lOANiD;
	}
	public String getlOANtYPE() {
		return lOANtYPE;
	}
	public void setlOANtYPE(String lOANtYPE) {
		this.lOANtYPE = lOANtYPE;
	}
	public int getdURATIONiNyEARS() {
		return dURATIONiNyEARS;
	}
	public void setdURATIONiNyEARS(int dURATIONiNyEARS) {
		this.dURATIONiNyEARS = dURATIONiNyEARS;
	}
	
	

}
