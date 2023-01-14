package com.salon.shop_notice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.service.Shop_NoticeService;

@SpringBootTest
class DeleteTests {
	
	@Autowired
	Shop_NoticeService service;

	@Test
	void contextLoads() {
		try {
			service.remove(5);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}