package com.salon.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Item;
import com.salon.service.ItemService;

@SpringBootTest
class UpdateTest {
	
	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		try {
			Item item = new Item(102,"sejong","목욕",40000,"bath.img");
			service.modify(item);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
