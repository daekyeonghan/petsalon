package com.salon.shop_notice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salon.dto.Shop_Notice;
import com.salon.service.Shop_NoticeService;

@SpringBootTest
class SelectTests {
	
	@Autowired
	Shop_NoticeService service;

	@Test
	void contextLoads() {
		Shop_Notice sn = null;
		try {
			sn = service.get(1);
			System.out.println(sn);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
	}

}
