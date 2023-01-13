package com.salon.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Item;
import com.salon.service.ItemService;

@SpringBootTest
class InsertTest {
	
	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		Item Item = new Item(0,"sejong","목욕",40000,"bath.img");
		try {
			service.register(Item);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
