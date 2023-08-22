package com.example.backend.services;

import java.util.List;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.ItemsMaster;

public interface ItemsMasterService {
	
	public List<ItemsMaster> getAllItems();
	
	public ItemsMaster getItemById(String itemId) throws ResourceNotFoundException;
	
	public void deleteItemById(String itemId);
	
	public ItemsMaster updateItem(ItemsMaster itemsMaster, ItemsMaster newItemsMaster);
	
	public List<String> getAllCategory();
	
	public ItemsMaster getItemByMakeAndCategory(String category, String make) throws ResourceNotFoundException;
	
	public List<String> getDistinctMakesByCategory (String category) throws ResourceNotFoundException;

	
	public ItemsMaster addItem (ItemsMaster item);
}
