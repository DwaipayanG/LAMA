package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.dao.ItemsMasterRepository;

@Service
public class ItemsMasterService {

	@Autowired
	ItemsMasterRepository itemsMasterRepo;
	
	
}
