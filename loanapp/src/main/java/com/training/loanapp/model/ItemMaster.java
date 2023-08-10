package com.training.loanapp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.persistence.Column;

@Entity
@Table(name = "item_master")
public class ItemMaster {
	@Id
	@Column(name = "item_id", length=6)
	private String iTEMiD;
	@Column(name = "item_description", length=25)
	private String iTEMdESCRIPTION;
	@Column(name="item_status", length=1)
	private String iTEMsTATUS;
	@Column(name="item_make", length=25)
	private String iTEMmAKE;
	@Column(name="item_category", length=20)
	private String iTEMcATEGORY;
	@Column(name="item_valuation")
	private int iTEMvALUATION;
	public String getiTEMiD() {
		return iTEMiD;
	}
	public void setiTEMiD(String iTEMiD) {
		this.iTEMiD = iTEMiD;
	}
	public String getiTEMdESCRIPTION() {
		return iTEMdESCRIPTION;
	}
	public void setiTEMdESCRIPTION(String iTEMdESCRIPTION) {
		this.iTEMdESCRIPTION = iTEMdESCRIPTION;
	}
	public String getiTEMsTATUS() {
		return iTEMsTATUS;
	}
	public void setiTEMsTATUS(String iTEMsTATUS) {
		this.iTEMsTATUS = iTEMsTATUS;
	}
	public String getiTEMmAKE() {
		return iTEMmAKE;
	}
	public void setiTEMmAKE(String iTEMmAKE) {
		this.iTEMmAKE = iTEMmAKE;
	}
	public String getiTEMcATEGORY() {
		return iTEMcATEGORY;
	}
	public void setiTEMcATEGORY(String iTEMcATEGORY) {
		this.iTEMcATEGORY = iTEMcATEGORY;
	}
	public int getiTEMvALUATION() {
		return iTEMvALUATION;
	}
	public void setiTEMvALUATION(int iTEMvALUATION) {
		this.iTEMvALUATION = iTEMvALUATION;
	}
	
	
	
	

	
	
}
