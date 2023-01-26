package com.salon.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.User;
import com.salon.service.UserService;

@SpringBootTest
class UserSearchAllTests {

	@Autowired
	UserService service;
	
	@Test
	void contextLoads() {
		
		List<User> objs = null;
		
		try {
			objs = service.usersearch("");
			System.out.println(objs);
			for(User obj : objs) {
				System.out.println(obj);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
	}

}
