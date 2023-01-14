package com.salon.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.UserService;

@SpringBootTest
class DeleteTests {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		try {
			service.remove("test@test.com");
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}
