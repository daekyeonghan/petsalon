package com.salon.designer;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Designer;
import com.salon.service.DesignerService;



@SpringBootTest
class SelectTests {
	
	@Autowired
	DesignerService service;

	@Test
	void contextLoads() {
		Designer dsn = null;
		try {
			dsn = service.get("babo");
			System.out.println(dsn);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		
	}

}
