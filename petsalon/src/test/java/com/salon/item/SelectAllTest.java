package com.salon.item;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.ItemService;

@SpringBootTest
class SelectAllTest {
	
	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		List list = null;
		try {
			list = service.get();
			System.out.println(list);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}

}
