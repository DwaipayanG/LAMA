package com.example.backend.exception;

public class ResourceNotFoundException extends Exception{
	private String message;

	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
