package com.salon.item;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Item;
import com.salon.service.ItemService;

@SpringBootTest
class dsPagingTest {
	
	@Autowired
	ItemService iservice;
	
	@Test
	void contextLoads() {
		List<Item> ilist = null;
	
					
			try {
				ilist = iservice.sortitem("menuTest", 6, 6);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(ilist);
	}

}
