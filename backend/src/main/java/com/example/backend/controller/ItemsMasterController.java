package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.ItemsMaster;
import com.example.backend.services.ItemsMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ItemsMasterController {
	
	@Autowired
	private ItemsMasterService itemsMasterService;
	
	@PostMapping("/getDistinctMakesByCategory")
	@ResponseBody
	public List<String> getDistinctMakesByCategory(@RequestBody ItemsMaster itemsMaster){
		return itemsMasterService.getDistinctMakesByCategory(itemsMaster.getItemCategory());
	}

}
