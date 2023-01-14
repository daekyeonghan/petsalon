package com.salon.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Admin;
import com.salon.service.AdminService;

@SpringBootTest
class SelectTest {
	
	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		Admin Admin = null;
		try {
			Admin = service.get("admin01");
			System.out.println(Admin);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
