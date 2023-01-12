package com.salon.designer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Designer;
import com.salon.service.DesignerService;



@SpringBootTest
class UpdateTests {
	
	@Autowired
	DesignerService service;

	@Test
	void contextLoads() {
		Designer dsn = new Designer("jojo","admin01", "세진짱", 10,"헤헤",null,null);
		try {
			service.modify(dsn);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		
	}

}
