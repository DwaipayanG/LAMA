package com.example.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.models.ItemsMaster;

public interface ItemsMasterRepository extends JpaRepository <ItemsMaster , String>  {


	@Query("SELECT DISTINCT itemMake FROM ItemsMaster WHERE itemCategory = :category")
	List<String> findDistinctMakesByCategory(String category);

	
	@Query ("SELECT DISTINCT itemCategory from ItemsMaster")
	List<String> getAllCategory();

}
