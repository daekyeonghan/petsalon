package com.salon.designer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.DesignerService;

@SpringBootTest
class DeleteTests {
	
	@Autowired
	DesignerService service;

	@Test
	void contextLoads() {
		try {
			service.remove("sejin");
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		
	}

}
