package com.salon.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.UserService;

@SpringBootTest
class FindEmailTests {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		try {
			String useremail = service.findemail("국세진","01099998888");
			System.out.println(useremail);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}
