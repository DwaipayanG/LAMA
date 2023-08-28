package com.example.backend.dto;

public class ItemsMasterDTO {
	
	private String itemId;
	private String itemDescription;
	private char itemStatus;
	private String itemMake;
	private String itemCategory;
	private int itemValuation;
	
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
	public void setItemStatus(char itemStatus) {
		this.itemStatus = itemStatus;
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
	
	

}
