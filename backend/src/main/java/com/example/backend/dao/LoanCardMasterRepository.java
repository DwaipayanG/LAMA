package com.example.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.models.LoanCardMaster;

public interface LoanCardMasterRepository extends JpaRepository <LoanCardMaster , String>  {

}
