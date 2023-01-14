package com.salon.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.User;
import com.salon.service.UserService;

@SpringBootTest
class UpdateTests {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
	User obj = new User("test@test.com", "testtest!", "홍길동", "20000909", "01012121212", "제주특별시", "10201");
		
		try {
			service.modify(obj);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}
