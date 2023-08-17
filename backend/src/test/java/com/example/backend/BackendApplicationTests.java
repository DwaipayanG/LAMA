package com.example.backend;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages="com")
@SpringBootTest(classes= com.example.backend.LoanCardMasterTest.class)

class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
