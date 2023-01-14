package com.salon.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Admin;
import com.salon.service.AdminService;

@SpringBootTest
class InsertTest {
	
	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		Admin Admin = new Admin("admin03","pwd03");
		try {
			service.register(Admin);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
