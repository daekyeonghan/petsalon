package com.salon.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.User;
import com.salon.service.UserService;

@SpringBootTest
class SelectTests {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		User obj;
		
		try {
			obj = service.get("helloworld@gmail.com");
			System.out.println(obj);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}
