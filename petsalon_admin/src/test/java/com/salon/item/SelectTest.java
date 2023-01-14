package com.salon.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Item;
import com.salon.service.ItemService;

@SpringBootTest
class SelectTest {
	
	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		Item Item = null;
		try {
			Item = service.get(100);
			System.out.println(Item);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
