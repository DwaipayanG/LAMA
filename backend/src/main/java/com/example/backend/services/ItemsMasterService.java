package com.example.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.ItemsMasterRepository;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.ItemsMaster;

@Service
public class ItemsMasterService {

	@Autowired
	private ItemsMasterRepository itemsMasterRepo;
	
	public List<ItemsMaster> getAllItems(){
		return itemsMasterRepo.findAll();
	}
	
	public ItemsMaster getItemById(String itemId) throws ResourceNotFoundException{
		ItemsMaster item =  itemsMasterRepo.findById(itemId).orElse(null);
		if(item == null) {
			throw new ResourceNotFoundException("Item not found");
		}else {
			return item;
		}
	}
	
	public void deleteItemById(String itemId) {
		itemsMasterRepo.deleteById(itemId);
	}
	
	public ItemsMaster updateItem(ItemsMaster itemsMaster, ItemsMaster newItemsMaster) {
		itemsMaster.setItemDescription(newItemsMaster.getItemDescription());
		itemsMaster.setItemMake(newItemsMaster.getItemMake());
		itemsMaster.setItemStatus(newItemsMaster.getItemStatus());
		itemsMaster.setItemValuation(newItemsMaster.getItemValuation());
		return itemsMaster;
		
	}
	
	public List<String> getAllCategory(){
		return itemsMasterRepo.getAllCategory();	
	}
	
	public ItemsMaster getItemByMakeAndCategory(String category, String make) {
		return itemsMasterRepo.getItemByMakeAndCategory(category, make);
	}

	
	public List<String> getDistinctMakesByCategory (String category){
		return itemsMasterRepo.findDistinctMakesByCategory(category);
	}
	
	public ItemsMaster addItem (ItemsMaster item){
		return itemsMasterRepo.save(item);
	
	}
}
