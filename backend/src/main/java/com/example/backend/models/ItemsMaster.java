package com.example.backend.models;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="items_master")
public class ItemsMaster {
	@Id
	@Column(name="item_id", nullable=false, length=4)
	private String itemId;
	
	@Column(name="item_description", length=25)
	private String itemDescription;
	
	@Column(name="item_status")
	private char itemStatus;
	
	@Column(name="item_make", length=25)
	private String itemMake;
	
	@Column(name="item_category", length=20)
	private String itemCategory;
	
	@Column(name="item_valuation")
	private int itemValuation;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="itemsMaster",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<EmployeeIssueDetails> employeeIssueDetails;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public char getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(char string) {
		this.itemStatus = string;
	}

	public String getItemMake() {
		return itemMake;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemValuation() {
		return itemValuation;
	}

	public void setItemValuation(int itemValuation) {
		this.itemValuation = itemValuation;
	}

	public List<EmployeeIssueDetails> getEmployeeIssueDetails() {
		return employeeIssueDetails;
	}

	public void setEmployeeIssueDetails(List<EmployeeIssueDetails> employeeIssueDetails) {
		this.employeeIssueDetails = employeeIssueDetails;
	}

	public ItemsMaster(ItemsMaster item) {
		this.itemId = item.getItemId();
		this.itemDescription = item.getItemDescription();
		this.itemStatus = item.getItemStatus();
		this.itemMake = item.getItemMake();
		this.itemCategory = item.getItemCategory();
		this.itemValuation = item.getItemValuation();
		this.employeeIssueDetails = item.getEmployeeIssueDetails();
	}
	
	public ItemsMaster() {}
	
	

}
