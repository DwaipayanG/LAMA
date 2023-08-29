package com.example.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {
	
	@Bean
	public ModelMapper ModelMap(){
		return new ModelMapper();		
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
	}

}
