package com.salon.designer;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Designer;
import com.salon.service.DesignerService;



@SpringBootTest
class DesignerItemTests {
	
	@Autowired
	DesignerService service;

	@Test
	void contextLoads() {
		List<Designer> dsns = null;
		try {
			dsns = service.designerItem();
			for(Designer dsn:dsns) {
				System.out.println(dsn);
			}
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		
	}

}
