package com.salon.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.ItemService;

@SpringBootTest
class DeleteTest {
	
	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(103);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
