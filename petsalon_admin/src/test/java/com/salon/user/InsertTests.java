package com.salon.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.User;
import com.salon.service.UserService;

@SpringBootTest
class InsertTests {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		User obj = new User("test@test.com", "testtest!", "테스트", "19990909", "01012121212", "서울특별시", "아파트","10101");
		
		try {
			service.register(obj);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}
