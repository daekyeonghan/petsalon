package com.salon.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.AdminService;

@SpringBootTest
class DeleteTest {
	
	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove("admin03");
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
