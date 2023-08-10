package com.example.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.models.ItemsMaster;

public interface ItemsMasterRepository extends JpaRepository <ItemsMaster , String>  {

}
