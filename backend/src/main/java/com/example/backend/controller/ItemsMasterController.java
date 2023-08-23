package com.example.backend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exception.DataUnavailableException;
import com.example.backend.exception.DuplicateEntryException;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.ItemsMaster;
import com.example.backend.services.ItemsMasterServiceImpl;

import jakarta.validation.Valid;

@RestController
@Validated
@CrossOrigin("http://localhost:3000")
public class ItemsMasterController {
	
	@Autowired
	private ItemsMasterServiceImpl itemsMasterService;
	
	@GetMapping("/api/item/all-items")
	public List<ItemsMaster> getAllItems() throws DataUnavailableException{
		List<ItemsMaster> allItems = itemsMasterService.getAllItems();
		if(allItems.size()==0)
			throw new DataUnavailableException("No Items present");
		else
			return allItems;
	}
	
	@GetMapping("/api/item/makes-by-category")
	@ResponseBody
	public List<String> getDistinctMakesByCategory(@Valid @RequestParam("itemCategory") String itemCategory) throws ResourceNotFoundException{
		return itemsMasterService.getDistinctMakesByCategory(itemCategory);
	}
	
	@GetMapping("/api/item/all-category")
	public List<String> getAllCategory(){
		return itemsMasterService.getAllCategory();
	}
	
	@GetMapping("/api/item/by-make-and-category")
	public ItemsMaster getItemByMakeAndCategory(@Valid @RequestParam("itemCategory") String itemCategory,@Valid @RequestParam("itemMake") String itemMake) throws ResourceNotFoundException {
		return itemsMasterService.getItemByMakeAndCategory(itemCategory, itemMake);
	}
	
	@GetMapping("/api/item/by-item-id")
	public ItemsMaster getItemById(@Valid @RequestParam("itemId") String itemId) throws ResourceNotFoundException {
		return itemsMasterService.getItemById(itemId);
	}

	@PostMapping("/api/item")
	public ItemsMaster addItem(@Valid @RequestBody ItemsMaster itemsMaster) throws DuplicateEntryException {
		try {
			this.getItemById(itemsMaster.getItemId());
			throw new DuplicateEntryException("Item already exists!");
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			return itemsMasterService.addItem(itemsMaster);
		}
	}
	
	@PutMapping("/api/item")
	public ItemsMaster updateItem(@Valid @RequestParam String itemId,@Valid @RequestBody ItemsMaster newItemsMaster) throws ResourceNotFoundException {

		ItemsMaster itemsMaster = itemsMasterService.getItemById(itemId);
		itemsMaster = itemsMasterService.updateItem(itemsMaster, newItemsMaster);
		itemsMasterService.addItem(itemsMaster);
		return itemsMaster;
	}
	

	
	@GetMapping("/deleteItem")
	public String deleteItemById(@Valid @RequestParam String itemId) {
		itemsMasterService.deleteItemById(itemId);
		return "deleted";
	}
	
	
}
