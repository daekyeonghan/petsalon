package com.salon.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.UserService;

@SpringBootTest
class FindPwdTests {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		try {
			String userpwd = service.findpwd("helloworld@gmail.com");
			System.out.println(userpwd);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}
