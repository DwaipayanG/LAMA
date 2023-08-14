package com.example.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.ItemsMasterRepository;

@Service
public class ItemsMasterService {

	@Autowired
	private ItemsMasterRepository itemsMasterRepo;
	
	public List<String> getDistinctMakesByCategory (String category){
		return itemsMasterRepo.findDistinctMakesByCategory(category);
	}
}
