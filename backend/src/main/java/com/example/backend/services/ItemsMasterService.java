package com.example.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.ItemsMasterRepository;
import com.example.backend.models.ItemsMaster;

@Service
public class ItemsMasterService {

	@Autowired
	private ItemsMasterRepository itemsMasterRepo;
	
	public List<String> getAllCategory(){
		return itemsMasterRepo.getAllCategory();	
	}
	
	public ItemsMaster getItemByMakeAndCategory(String category, String make) {
		return itemsMasterRepo.getItemByMakeAndCategory(category, make);
	}

	
	public List<String> getDistinctMakesByCategory (String category){
		return itemsMasterRepo.findDistinctMakesByCategory(category);
	}
}