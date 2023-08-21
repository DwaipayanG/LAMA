package com.example.backend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.ItemsMaster;
import com.example.backend.services.ItemsMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ItemsMasterController {
	
	@Autowired
	private ItemsMasterService itemsMasterService;
	
	@GetMapping("/getAllItem")
	public List<ItemsMaster> getAllItems(){
		return itemsMasterService.getAllItems();
	}
	
	@PostMapping("/getDistinctMakesByCategory")
	@ResponseBody
	public List<String> getDistinctMakesByCategory(@RequestBody ItemsMaster itemsMaster){
		return itemsMasterService.getDistinctMakesByCategory(itemsMaster.getItemCategory());
	}
	
	@GetMapping("/getAllCategory")
	public List<String> getAllCategory(){
		return itemsMasterService.getAllCategory();
	}
	
	@GetMapping("/getItemByMakeAndCategory")
	public ItemsMaster getItemByMakeAndCategory(@RequestParam("itemCategory") String itemCategory, @RequestParam("itemMake") String itemMake) {
		return itemsMasterService.getItemByMakeAndCategory(itemCategory, itemMake);
	}
	
	@GetMapping("/getItemById")
	public ItemsMaster getItemById(@RequestParam("itemId") String itemId) throws ResourceNotFoundException {
		return itemsMasterService.getItemById(itemId);
	}

	@PostMapping("/addItem")
	public ItemsMaster addItem(@RequestBody ItemsMaster itemsMaster) {
		return itemsMasterService.addItem(itemsMaster);
	}
	
	@PutMapping("/updateItem")
	public ItemsMaster updateItem(@RequestParam String itemId,@RequestBody ItemsMaster newItemsMaster) throws ResourceNotFoundException {
		ItemsMaster itemsMaster = itemsMasterService.getItemById(itemId);
		itemsMaster = itemsMasterService.updateItem(itemsMaster, newItemsMaster);
		itemsMasterService.addItem(itemsMaster);
		return itemsMaster;
	}
	

	
	@GetMapping("/deleteItem")
	public String deleteItemById(@RequestParam String itemId) {
		itemsMasterService.deleteItemById(itemId);
		return "deleted";
	}
	
	
}
