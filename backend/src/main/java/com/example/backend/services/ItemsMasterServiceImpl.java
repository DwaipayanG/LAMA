package com.example.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.ItemsMasterRepository;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.ItemsMaster;

@Service
public class ItemsMasterServiceImpl implements ItemsMasterService {

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
	
	public ItemsMaster getItemByMakeAndCategory(String category, String make) throws ResourceNotFoundException {
		ItemsMaster item = itemsMasterRepo.getItemByMakeAndCategory(category, make);
		if(item == null) {
			throw new ResourceNotFoundException("No item of this category and make");
		}else {
			return item;
		}
	}

	
	public List<String> getDistinctMakesByCategory (String category) throws ResourceNotFoundException{
		List<String> makes =  itemsMasterRepo.findDistinctMakesByCategory(category);
		if(makes.isEmpty()) {
			throw new ResourceNotFoundException("No makes of this item category");
		}else {
			return makes;
		}
	}
	
	public ItemsMaster addItem (ItemsMaster item){
		return itemsMasterRepo.save(item);
	
	}
}
