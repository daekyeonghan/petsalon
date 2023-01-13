package com.salon.designer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Designer;
import com.salon.service.DesignerService;



@SpringBootTest
class InsertTests {
	
	@Autowired
	DesignerService service;

	@Test
	void contextLoads() {
		Designer dsn = new Designer("sejin","admin01", "JSJ", 10,"헤이 모두들 안녕",null,null);
		try {
			service.register(dsn);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		
	}

}
